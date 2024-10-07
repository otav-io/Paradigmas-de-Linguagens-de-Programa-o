class Retangulo:

    def __init__(self, comprimento, largura):
        self.comprimento = comprimento
        self.largura = largura

    def calcular_area(self):
        area = self.comprimento * self.largura
        return area

    def calcular_perimetro(self):
        perimetro = 2 * (self.comprimento + self.largura)
        return perimetro

ret = Retangulo(200, 300)
area = ret.calcular_area()
perimetro = ret.calcular_perimetro()

print(f"area: {area}")
print(f"Perimetro: {perimetro}")
