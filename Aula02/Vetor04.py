# Faça um programa em Python que receba 6 numeros inteiros e mostre: ´
#  • Os numeros pares digitados; 
#  • A soma dos numeros pares digitados; 
#  • Os numeros   ımpares digitados;
#  • A quantidade de numeros  ımpares 

def main():
    numeros = [int(input("Digite um número: ")) for _ in range(6)]

    numeros_pares = [num for num in numeros if num % 2 == 0]
    numeros_impares = [num for num in numeros if num % 2 != 0]

    soma_pares = sum(numeros_pares)

    print("Os números pares digitados são:", *numeros_pares)
    print("A soma dos números pares digitados é:", soma_pares)
    print("Os números ímpares digitados são:", *numeros_impares)
    print("A quantidade de números ímpares digitados é:", len(numeros_impares))

if __name__ == "__main__":
    main()
