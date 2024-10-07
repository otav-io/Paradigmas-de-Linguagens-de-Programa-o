package main

import (
	"errors"
	"fmt"
	"sync"
)

// Questão 1: Classes e Objetos Básicos
type Carro struct {
	Marca  string
	Modelo string
	Ano    int
}

func (c Carro) String() string {
	return fmt.Sprintf("%s %s (%d)", c.Marca, c.Modelo, c.Ano)
}

func questao1() {
	fmt.Println("Executando Questao 1")
	carros := []Carro{
		{"Toyota", "Hilux", 2024},
		{"Kia", "Sorento", 2015},
		{"Mitsubishi", "Lancer", 2012},
	}
	for _, carro := range carros {
		fmt.Println(carro)
	}
	fmt.Println()
}

// Questão 2: Métodos
type CarroComVelocidade struct {
	Carro
	Velocidade int
}

func (c *CarroComVelocidade) Acelerar() {
	c.Velocidade += 10
}

func (c *CarroComVelocidade) Frear() {
	c.Velocidade -= 10
	if c.Velocidade < 0 {
		c.Velocidade = 0
	}
}

func (c CarroComVelocidade) ExibirVelocidade() {
	fmt.Printf("Velocidade atual: %d km/h\n", c.Velocidade)
}

func questao2() {
	fmt.Println("Executando Questao 2")
	carro := CarroComVelocidade{Carro: Carro{"Toyota", "Hilux", 2024}}
	carro.Acelerar()
	carro.ExibirVelocidade()
	carro.Acelerar()
	carro.ExibirVelocidade()
	carro.Frear()
	carro.ExibirVelocidade()
	carro.Frear()
	carro.ExibirVelocidade()
	fmt.Println()
}

// Questão 3: Encapsulamento
type ContaBancaria struct {
	titular string
	saldo   float64
}

func (c *ContaBancaria) Depositar(valor float64) {
	c.saldo += valor
}

func (c *ContaBancaria) Sacar(valor float64) error {
	if valor > c.saldo {
		return errors.New("saldo insuficiente")
	}
	c.saldo -= valor
	return nil
}

func (c ContaBancaria) ExibirSaldo() {
	fmt.Printf("Saldo atual: R$%.2f\n", c.saldo)
}

func questao3() {
	fmt.Println("Executando Questao 3")
	conta := ContaBancaria{titular: "Joao", saldo: 700}
	conta.ExibirSaldo()
	conta.Sacar(100)
	conta.ExibirSaldo()
	err := conta.Sacar(600)
	if err != nil {
		fmt.Println("Saldo insuficiente")
	} else {
		conta.ExibirSaldo()
	}
	fmt.Println()
}

// Questão 4: Herança
type Animal interface {
	Som() string
	Comportamento() string
}

type Cachorro struct{}

func (Cachorro) Som() string {
	return "Au Au"
}

func (Cachorro) Comportamento() string {
	return "O cachorro corre atras do proprio rabo."
}

type Gato struct{}

func (Gato) Som() string {
	return "Miau"
}

func (Gato) Comportamento() string {
	return "O gato destroi toda a casa fingindo que nada aconteceu (bicho maligno)."
}

type Pato struct{}

func (Pato) Som() string {
	return "Quack"
}

func (Pato) Comportamento() string {
	return "O pato nada no lago."
}

type Pinto struct{}

func (Pinto) Som() string {
	return "piu"
}

func (Pinto) Comportamento() string {
	return "o pinto sai do ovo"
}

func questao4() {
	fmt.Println("Executando Questao 4")
	animais := []Animal{
		Cachorro{},
		Gato{},
		Pato{},
		Pinto{},
	}

	for _, animal := range animais {
		fmt.Printf("%T:\nSom: %s\nComportamento: %s\n\n", animal, animal.Som(), animal.Comportamento())
	}
	fmt.Println()
}

// Questão 5: Polimorfismo
func emitirSons(animais []Animal) {
	for _, animal := range animais {
		fmt.Printf("%T: %s\n", animal, animal.Som())
	}
}

func questao5() {
	fmt.Println("Executando Questao 5")
	animais := []Animal{
		Cachorro{},
		Gato{},
		Pato{},
		Pinto{},
	}
	emitirSons(animais)
	fmt.Println()
}

// Questão 6: Composição
type Motor struct {
	Cavalos int
}

type CarroComMotor struct {
	Carro
	Motor Motor
}

func questao6() {
	fmt.Println("Executando Questao 6")
	carros := []CarroComMotor{
		{Carro{"Toyota", "Hilux", 2024}, Motor{204}},
		{Carro{"Kia", "Sorento", 2015}, Motor{194}},
		{Carro{"Mitsubishi", "Lancer", 2012}, Motor{160}},
	}
	for _, carro := range carros {
		fmt.Printf("%s com motor de %d CV.\n", carro.Carro, carro.Motor.Cavalos)
	}
	fmt.Println()
}

// Questão 7: Associação
type Professor struct {
	Nome string
}

type Escola struct {
	Nome        string
	Professores []Professor
}

func questao7() {
	fmt.Println("Executando Questao 7")

	escolaA := Escola{"Escola A", []Professor{{"Ricardo"}, {"Leonardo"}}}
	escolaB := Escola{"Escola B", []Professor{{"Douglas"}, {"Leonardo"}}}

	fmt.Printf("Professores na %s:\n", escolaA.Nome)
	for _, professor := range escolaA.Professores {
		fmt.Println(professor.Nome)
	}

	fmt.Printf("\nProfessores na %s:\n", escolaB.Nome)
	for _, professor := range escolaB.Professores {
		fmt.Println(professor.Nome)
	}
	fmt.Println()
}

// Questão 8: Agregação
type Empregado struct {
	Nome    string
	Cargo   string
	Salario float64
}

type Empresa struct {
	Empregados []Empregado
}

func questao8() {
	fmt.Println("Executando Questao 8")
	empresa := Empresa{
		Empregados: []Empregado{
			{"Matheus", "Desenvolvedor", 3000},
			{"Lauane", "RH", 3500},
			{"Otavio", "Analista de Dados", 4000},
		},
	}
	for _, empregado := range empresa.Empregados {
		fmt.Printf("Empregado: %s, Cargo: %s, Salario: R$%.2f\n", empregado.Nome, empregado.Cargo, empregado.Salario)
	}
	fmt.Println()
}

// Questão 9: Interfaces/Protocolos
type Imprimivel interface {
	Imprimir()
}

type Relatorio struct{}

func (Relatorio) Imprimir() {
	fmt.Println("Imprimindo relatorio...")
}

type Contrato struct{}

func (Contrato) Imprimir() {
	fmt.Println("Imprimindo contrato...")
}

func questao9() {
	fmt.Println("Executando Questao 9")
	var imprimiveis []Imprimivel = []Imprimivel{Relatorio{}, Contrato{}}
	for _, imprimivel := range imprimiveis {
		imprimivel.Imprimir()
	}
	fmt.Println()
}

// Questão 10: Sobrecarga de Métodos
func somarDois(a, b int) int {
	return a + b
}

func somarTres(a, b, c int) int {
	return a + b + c
}

func questao10() {
	fmt.Println("Executando Questao 10")
	fmt.Println(somarDois(1, 2))
	fmt.Println(somarTres(1, 2, 3))
	fmt.Println()
}

// Questão 11: Classes Abstratas
type Funcionario interface {
	CalcularSalario() float64
}

type FuncionarioHorista struct {
	HorasTrabalhadas int
	ValorHora        float64
}

func (f FuncionarioHorista) CalcularSalario() float64 {
	return float64(f.HorasTrabalhadas) * f.ValorHora
}

type FuncionarioAssalariado struct {
	SalarioBase float64
}

func (f FuncionarioAssalariado) CalcularSalario() float64 {
	return f.SalarioBase
}

func questao11() {
	fmt.Println("Executando Questao 11")
	horista := FuncionarioHorista{HorasTrabalhadas: 160, ValorHora: 20}
	assalariado := FuncionarioAssalariado{SalarioBase: 3000}

	fmt.Printf("Salario Horista: %.2f\n", horista.CalcularSalario())
	fmt.Printf("Salario Assalariado: %.2f\n", assalariado.CalcularSalario())
	fmt.Println()
}

// Questão 12: Sobrecarga de Operadores
type Produto struct {
	Preco float64
}

func somarPrecos(p1, p2 Produto) float64 {
	return p1.Preco + p2.Preco
}

func questao12() {
	fmt.Println("Executando Questao 12")
	prod1 := Produto{Preco: 100}
	prod2 := Produto{Preco: 200}
	fmt.Printf("Soma dos precos: R$%.2f\n", somarPrecos(prod1, prod2))
	fmt.Println()
}

// Questão 13: Métodos Estáticos
func Fatorial(n int) int {
	if n == 0 {
		return 1
	}
	return n * Fatorial(n-1)
}

func questao13() {
	fmt.Println("Executando Questao 13")
	fmt.Printf("Fatorial de 5: %d\n", Fatorial(5))
	fmt.Println()
}

// Questão 14: Singleton
type Configuracao struct{}

var instance *Configuracao
var once sync.Once

func GetInstance() *Configuracao {
	once.Do(func() {
		instance = &Configuracao{}
	})
	return instance
}

func questao14() {
	fmt.Println("Executando Questao 14")
	config1 := GetInstance()
	config2 := GetInstance()
	fmt.Println(config1 == config2) // True
	fmt.Println()
}

// Questão 15: Exceções/Erros Personalizados
type SaldoInsuficienteError struct{}

func (e *SaldoInsuficienteError) Error() string {
	return "Saldo insuficiente para realizar o saque."
}

func questao15() {
	fmt.Println("Executando Questao 15")
	conta := ContaBancaria{titular: "Joao", saldo: 500}
	err := conta.Sacar(600)
	if err != nil {
		fmt.Println(err)
	} else {
		conta.ExibirSaldo()
	}
	err = conta.Sacar(100)
	if err != nil {
		fmt.Println(err)
	} else {
		conta.ExibirSaldo()
	}
	fmt.Println()
}

// Função principal para executar todas as questões
func main() {
	questao1()
	questao2()
	questao3()
	questao4()
	questao5()
	questao6()
	questao7()
	questao8()
	questao9()
	questao10()
	questao11()
	questao12()
	questao13()
	questao14()
	questao15()
}
