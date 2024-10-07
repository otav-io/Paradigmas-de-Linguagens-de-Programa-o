# lê um vetor de 8 posições e, em seguida, lê dois valores X e Y 
# quaisquer correspondentes a duas posições no vetor. 
# O programa então imprime a soma dos valores encontrados nas 
# respectivas posições X e Y.

def ler_vetor(tamanho=8):
    return [int(input(f"Digite o valor da posição {i}: ")) for i in range(tamanho)]

def ler_indices():
    x = int(input("Digite o valor de X: "))
    y = int(input("Digite o valor de Y: "))
    return x, y

def calcular_soma(vetor, x, y):
    try:
        return vetor[x] + vetor[y]
    except IndexError:
        print("Erro: uma das posições inseridas está fora do intervalo do vetor.")
        return None

def main():
    vetor = ler_vetor()
    x, y = ler_indices()
    soma = calcular_soma(vetor, x, y)
    
    if soma is not None:
        print(f"A soma dos valores nas posições {x} e {y} é {soma}.")

if __name__ == "__main__":
    main()
