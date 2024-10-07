package main

import "fmt"

type Motor struct {
	Tipo     string
	Potencia int
}

func (m Motor) Ligar() {
	fmt.Println("Motor ligado.")
}

func (m Motor) Desligar() {
	fmt.Println("Motor desligado.")
}

type Pneu struct {
	Marca   string
	Tamanho int
}

func (p Pneu) Inflar() {
	fmt.Println("Pneu inflado.")
}

func (p Pneu) Desinflar() {
	fmt.Println("Pneu desinflado.")
}

type Carro struct {
	Marca  string
	Modelo string
	Motor  Motor
	Pneus  [4]Pneu
}

func CriarCarro(marca, modelo string) Carro {
	motor := Motor{"Gasolina", 160}
	pneus := [4]Pneu{}
	for i := range pneus {
		pneus[i] = Pneu{"Pirelli", 18}
	}
	return Carro{Marca: marca, Modelo: modelo, Motor: motor, Pneus: pneus}
}

func (c Carro) Ligar() {
	c.Motor.Ligar()
	fmt.Println("carro ligado.")
}

func (c Carro) Desligar() {
	c.Motor.Desligar()
	fmt.Println("Carro desligado.")
}

func (c *Carro) SubstituirPneu(pos int, novoPneu Pneu) {
	if pos >= 0 && pos < 4 {
		c.Pneus[pos] = novoPneu
		fmt.Printf("Pneu %d substituído.\n", pos+1)
	} else {
		fmt.Println("Posição de pneu inválida.")
	}
}

func main() {
	carro := CriarCarro("Mitsubishi", "Lancer")
	carro.Ligar()

	novoPneu := Pneu{"Michelin", 17}
	carro.SubstituirPneu(2, novoPneu)

	carro.Desligar()
}
