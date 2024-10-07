//criar a classe pessoa com nome e idade
//associar uma classe endereço as pessoas onde tera alocado informações de rua, cidade, estado, cep
//criar  uma classe empresa com nome, cnpj, e funcionarios
//fazer com que a as pessoas adicionadas sejam contratada pela empresa

package main

import "fmt"

type Endereco struct {
	Rua    string
	Cidade string
	Estado string
	Cep    string
}

func (e *Endereco) Exibir() {
	fmt.Printf("Endereço: %s, %s - %s, CEP: %s\n", e.Rua, e.Cidade, e.Estado, e.Cep)
}

type Pessoa struct {
	Nome     string
	Idade    int
	Endereco *Endereco
}

func CriarPessoa(nome string, idade int) Pessoa {
	return Pessoa{Nome: nome, Idade: idade}
}

func (p *Pessoa) DefinirEndereco(endereco *Endereco) {
	p.Endereco = endereco
}

func (p *Pessoa) MostrarDetalhes() {
	fmt.Printf("Nome: %s, Idade: %d\n", p.Nome, p.Idade)
	if p.Endereco != nil {
		p.Endereco.Exibir()
	} else {
		fmt.Println("Endereço não informado.")
	}
}

type Empresa struct {
	Nome         string
	Cnpj         string
	Funcionarios []Pessoa
}

func CriarEmpresa(nome string, cnpj string) *Empresa {
	return &Empresa{Nome: nome, Cnpj: cnpj}
}

func (e *Empresa) AdicionarFuncionario(pessoa Pessoa) {
	e.Funcionarios = append(e.Funcionarios, pessoa)
}

func (e *Empresa) ExibirFuncionarios() {
	fmt.Printf("Funcionários da %s:\n", e.Nome)
	for _, funcionario := range e.Funcionarios {
		fmt.Println(funcionario.Nome)
	}
}

func main() {
	endereco1 := &Endereco{"Loteamento Luis Carlos de Mendonça", "Goiana", "Pernambuco", "5900-000"}
	endereco2 := &Endereco{"Rua Pau Ferro", "João Pessoa", "Paraíba", "58010-030"}

	pessoa1 := CriarPessoa("Otavio", 20)
	pessoa2 := CriarPessoa("Fernanda", 21)

	pessoa1.DefinirEndereco(endereco1)
	pessoa2.DefinirEndereco(endereco2)

	empresa := CriarEmpresa("empresa", "12345678000199")
	empresa.AdicionarFuncionario(pessoa1)
	empresa.AdicionarFuncionario(pessoa2)

	empresa.ExibirFuncionarios()
}
