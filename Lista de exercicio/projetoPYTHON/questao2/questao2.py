class Carro:
    def __init__(self, marca, modelo, ano):
        self.marca = marca
        self.modelo = modelo
        self.ano = ano
        self.velocidade = 0

    def acelerar(self):
        self.velocidade += 10

    def frear(self):
        self.velocidade -= 10

    def exibir_velocidade(self):
        return f"Velocidade atual: {self.velocidade} km/h"

# Exemplo de uso:

def executar_questao2():
    carro = Carro("Mitsubishi", "lancer", 2012)
    carro.acelerar()
    print(carro.exibir_velocidade())
    carro.acelerar()
    print(carro.exibir_velocidade())
    carro.frear()
    print(carro.exibir_velocidade())
    carro.frear()
    print(carro.exibir_velocidade())
