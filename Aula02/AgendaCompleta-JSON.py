# Programa em Python para gerenciar uma agenda telefônica:

# Valida Dados de Contato: Recebe e valida nomes e números de telefone.
# Armazena Dados em um Dicionário: Usa um dicionário para armazenar contatos, onde a chave é o nome e o valor é o número de telefone.
# Salva e Carrega Dados em Arquivo .json: Grava e lê os dados em um arquivo JSON.
# Estrutura do Programa
# Coletar e Validar Dados:

# Receber nome e número de telefone do usuário.
# Validar o formato do número de telefone.
# Manipular Dados:

# Adicionar, editar e excluir contatos no dicionário.
# Salvar e Carregar Dados:

# Gravar e ler dados em um arquivo JSON.

import json
import re

def validar_numero(numero):
    padrao = re.compile(r"^\(\d{2}\) \d{5}-\d{4}$")
    return bool(padrao.match(numero))

def coletar_dados():
    nome = input("Digite o nome do contato: ")

    numero = input("Digite o número de telefone (formato: (11) 12345-6789): ")
    while not validar_numero(numero):
        print("Número de telefone inválido. Tente novamente.")
        numero = input("Digite o número de telefone (formato: (11) 12345-6789): ")

    return nome, numero

def salvar_em_arquivo(contatos, nome_arquivo):
    with open(nome_arquivo, 'w') as arquivo:
        json.dump(contatos, arquivo, indent=4)

def carregar_do_arquivo(nome_arquivo):
    try:
        with open(nome_arquivo, 'r') as arquivo:
            contatos = json.load(arquivo)
    except FileNotFoundError:
        contatos = {}
    return contatos

def exibir_contatos(contatos):
    if contatos:
        for nome, numero in contatos.items():
            print(f"Nome: {nome}, Telefone: {numero}")
    else:
        print("Nenhum contato encontrado.")

def excluir_contato(contatos):
    nome = input("Digite o nome do contato que deseja excluir: ")
    if nome in contatos:
        del contatos[nome]
        print(f"Contato '{nome}' excluído com sucesso.")
    else:
        print("Contato não encontrado.")

def main():
    nome_arquivo = 'agenda_telefonica.json'
    contatos = carregar_do_arquivo(nome_arquivo)
    
    while True:
        print("\nMenu:")
        print("1. Adicionar/Editar Contato")
        print("2. Exibir Contatos")
        print("3. Excluir Contato")
        print("4. Salvar e Sair")
        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            nome, numero = coletar_dados()
            contatos[nome] = numero
        elif escolha == '2':
            exibir_contatos(contatos)
        elif escolha == '3':
            excluir_contato(contatos)
        elif escolha == '4':
            salvar_em_arquivo(contatos, nome_arquivo)
            print(f"Dados salvos em '{nome_arquivo}'.")
            break
        else:
            print("Opção inválida. Tente novamente.")

if __name__ == "__main__":
    main()
