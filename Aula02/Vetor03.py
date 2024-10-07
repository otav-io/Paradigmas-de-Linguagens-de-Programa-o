# Faça um programa em Python que receba do usuario dois vetores, ´ A e B, 
# com 10 numeros inteiros cada. Crie um novo vetor denominado C 
# calculando C = A - B. Mostre na tela os dados
# do vetor C.

def main():
    vetor_a = [int(input(f"Digite o elemento {i} do vetor A: ")) for i in range(10)]
    vetor_b = [int(input(f"Digite o elemento {i} do vetor B: ")) for i in range(10)]

    vetor_c = [a - b for a, b in zip(vetor_a, vetor_b)]

    print("Vetor C:")
    for elemento in vetor_c:
        print(elemento)

if __name__ == "__main__":
    main()
