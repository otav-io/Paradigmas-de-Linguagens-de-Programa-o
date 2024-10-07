// Faça um programa em golang que receba do usuario
// um vetor com 10 posições. Em seguida devera ser
// impresso o maior e o menor elemento do vetor.

package main

import (
	"fmt"
)

func main() {
	var vetor [10]int

	fmt.Println("Digite 10 números inteiros:")
	for i := 0; i < 10; i++ {
		fmt.Printf("Número %d: ", i+1)
		fmt.Scan(&vetor[i])
	}

	maiorValor := vetor[0]
	menorValor := vetor[0]

	for _, valor := range vetor {
		if valor > maiorValor {
			maiorValor = valor
		}
		if valor < menorValor {
			menorValor = valor
		}
	}

	fmt.Printf("Maior valor: %d\n", maiorValor)
	fmt.Printf("Menor valor: %d\n", menorValor)
}
