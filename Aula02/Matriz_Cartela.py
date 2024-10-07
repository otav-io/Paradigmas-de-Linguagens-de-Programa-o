# Faça um programa em Python para gerar automaticamente numeros entre 0 e 99 de uma cartela de bingo. Sabendo que cada cartela devera conter 5 linhas de 5 numeros, gere estes dados de modo a nao ter numeros repetidos dentro das cartelas. O programa deve exibir na ´
# tela a cartela gerada.

import random

def gerar_cartela():
    numeros = set()
    cartela = []
    
    while len(numeros) < 25:
        numero = random.randint(0, 99)
        numeros.add(numero)
    
    lista_numeros = list(numeros)
    for i in range(5):
        cartela.append(lista_numeros[i * 5:(i + 1) * 5])
    
    return cartela

def exibir_cartela(cartela):

    print("Cartela de bingo:")
    for linha in cartela:
        print("\t".join(f"{num:02d}" for num in linha)) 

def main():
    cartela = gerar_cartela()
    exibir_cartela(cartela)

if __name__ == "__main__":
    main()
