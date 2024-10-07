class Carro:
    def __init__(self, marca, modelo, ano):
        self.marca = marca
        self.modelo = modelo
        self.ano = ano

    def exibir_detalhes(self):
        return f"{self.marca} {self.modelo} ({self.ano})"

def executar_questao1():
    carro1 = Carro("Toyota", "hilux", 2024)
    carro2 = Carro("Kya", "sorento", 2015)
    carro3 = Carro("Mitsubishi ", "lancer", 2012)

    carros = [carro1, carro2, carro3]

    for carro in carros:
        print(carro.exibir_detalhes())
    