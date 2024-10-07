package main

import "fmt"

type Animal struct {
	nome string
}

func (a Animal) EmitirSom() {
}

type Mamifero struct {
	Animal
}

func (m Mamifero) Amamentar() {
	fmt.Printf("%s esta amamentando.\n", m.nome)
}

type Ave interface {
	Voar()
}

type Morcego struct {
	Mamifero
}

func (m Morcego) EmitirSom() {
	fmt.Println("Morcego fazendo ruidos noturnos.")
}

func (m Morcego) Voar() {
	fmt.Printf("%s esta voando.\n", m.nome)
}

func main() {
	morcego := Morcego{Mamifero{Animal{"morcego"}}}
	morcego.EmitirSom()
	morcego.Amamentar()
	morcego.Voar()
}
