class Motor:
    def __init__(self, potencia):
        self.potencia = potencia

class Carro:
    def __init__(self, marca, modelo, ano, potencia_motor):
        self.marca = marca
        self.modelo = modelo
        self.ano = ano
        self.motor = Motor(potencia_motor)

    def detalhes_carro(self):
        return f"{self.marca} {self.modelo} ({self.ano}) com motor de {self.motor.potencia} CV."

def executar_questao6():
    carro1 = Carro("Toyota", "hilux", 2024, 204)
    carro2 = Carro("Kya", "sorento", 2015, 194)
    carro3 = Carro("Mitsubishi ", "lancer", 2012, 160)

    print(carro1.detalhes_carro())
    print(carro2.detalhes_carro())
    print(carro3.detalhes_carro())
