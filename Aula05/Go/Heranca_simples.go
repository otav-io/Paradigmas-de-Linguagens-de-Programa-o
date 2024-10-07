package main

import "fmt"

type Animal interface {
	EmitirSom() string
}

type Cachorro struct {
	nome string
}

func (c Cachorro) EmitirSom() string {
	return "Au Au"
}

type Gato struct {
	nome string
}

func (g Gato) EmitirSom() string {
	return "Miau"
}

func mostrarSom(animal Animal) {
	fmt.Println(animal.EmitirSom())
}

//Exemplo de uso
func main() {
	cachorro := Cachorro{nome: "Rex"}
	gato := Gato{nome: "Mimi"}

	fmt.Printf("%s diz: ", cachorro.nome)
	mostrarSom(cachorro)

	fmt.Printf("%s diz: ", gato.nome)
	mostrarSom(gato)
}
