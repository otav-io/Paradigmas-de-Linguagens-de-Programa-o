// Programa em golang para gerenciar uma agenda telefônica:
// Valida Dados de Contato: Recebe e valida nomes e números de telefone.
// Armazena Dados em um Dicionário: Usa um dicionário para armazenar contatos, onde a chave é o nome e o valor é o número de telefone.
// Salva e Carrega Dados em Arquivo .json: Grava e lê os dados em um arquivo JSON.
// Estrutura do Programa
// Coletar e Validar Dados:
// Receber nome e número de telefone do usuário.
// Validar o formato do número de telefone.
// Manipular Dados:
// Adicionar, editar e excluir contatos no dicionário.
// Salvar e Carregar Dados:
// Gravar e ler dados em um arquivo JSON.

package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"os"
	"regexp"
)

const fileName = "contacts.json"

var contacts = make(map[string]string)

func main() {
	if err := loadContacts(); err != nil {
		fmt.Println("Erro ao carregar contatos:", err)
	}

	menuLoop()
}

func menuLoop() {
	for {
		fmt.Println("\n1. Adicionar contato")
		fmt.Println("2. Editar contato")
		fmt.Println("3. Excluir contato")
		fmt.Println("4. Listar contatos")
		fmt.Println("5. Sair")
		fmt.Print("Escolha uma opção: ")

		var choice int
		fmt.Scan(&choice)

		switch choice {
		case 1:
			addContact()
		case 2:
			editContact()
		case 3:
			deleteContact()
		case 4:
			listContacts()
		case 5:
			if err := saveContacts(); err != nil {
				fmt.Println("Erro ao salvar contatos:", err)
			} else {
				fmt.Println("Contatos salvos com sucesso. Saindo...")
			}
			return
		default:
			fmt.Println("Opção inválida.")
		}
	}
}

func addContact() {
	var name, phone string
	fmt.Print("Nome: ")
	fmt.Scan(&name)
	fmt.Print("Número de telefone (somente números): ")
	fmt.Scan(&phone)

	// Formata e valida o número
	formattedPhone, err := formatPhoneNumber(phone)
	if err != nil {
		fmt.Println(err)
		return
	}

	contacts[name] = formattedPhone
	fmt.Println("Contato adicionado.")
}

func editContact() {
	var name, phone string
	fmt.Print("Nome do contato a ser editado: ")
	fmt.Scan(&name)

	if _, exists := contacts[name]; exists {
		fmt.Print("Novo número de telefone (somente números): ")
		fmt.Scan(&phone)

		// Formata e valida o número
		formattedPhone, err := formatPhoneNumber(phone)
		if err != nil {
			fmt.Println(err)
			return
		}

		contacts[name] = formattedPhone
		fmt.Println("Contato atualizado.")
	} else {
		fmt.Println("Contato não encontrado.")
	}
}

func deleteContact() {
	var name string
	fmt.Print("Nome do contato a ser excluído: ")
	fmt.Scan(&name)

	if _, exists := contacts[name]; exists {
		delete(contacts, name)
		fmt.Println("Contato excluído.")
	} else {
		fmt.Println("Contato não encontrado.")
	}
}

func listContacts() {
	if len(contacts) == 0 {
		fmt.Println("Nenhum contato encontrado.")
		return
	}
	fmt.Println("Contatos:")
	for name, phone := range contacts {
		fmt.Printf("Nome: %s, Telefone: %s\n", name, phone)
	}
}

// Valida e formata o número de telefone
func formatPhoneNumber(phone string) (string, error) {
	// Verifica se o número contém apenas dígitos
	re := regexp.MustCompile(`^\d{10}$`)
	if !re.MatchString(phone) {
		return "", fmt.Errorf("Número de telefone inválido. Deve conter exatamente 10 dígitos.")
	}

	// Formata o número para o formato (XX) XXXX-XXXX
	formatted := fmt.Sprintf("(%s) %s-%s", phone[:2], phone[2:6], phone[6:])
	return formatted, nil
}

func saveContacts() error {
	data, err := json.MarshalIndent(contacts, "", "  ")
	if err != nil {
		return err
	}
	return ioutil.WriteFile(fileName, data, 0644)
}

func loadContacts() error {
	file, err := os.Open(fileName)
	if err != nil {
		if os.IsNotExist(err) {
			return nil // Arquivo não encontrado, iniciar com contatos vazios
		}
		return err
	}
	defer file.Close()

	data, err := ioutil.ReadAll(file)
	if err != nil {
		return err
	}

	return json.Unmarshal(data, &contacts)
}
