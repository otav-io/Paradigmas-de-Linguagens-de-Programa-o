# Faça um programa em Python que receba do usuario 
# um vetor com 10 posições. Em seguida devera ser 
# impresso o maior e o menor elemento do vetor.

def main():
    vetor = [int(input(f"Digite o elemento {i}: ")) for i in range(10)]
    
    maior = max(vetor)
    menor = min(vetor)

    print(f"O maior elemento do vetor é {maior}.")
    print(f"O menor elemento do vetor é {menor}.")
    
if __name__ == "__main__":
    main()
