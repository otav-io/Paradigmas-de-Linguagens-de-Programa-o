class Triangulo:

    def __init__(self, lado1, lado2, lado3):
        self.lados = [lado1, lado2, lado3]

    def calcular_perimetro(self):
        return sum(self.lados)

    def tipo(self):
        if self.lados[0] == self.lados[1] == self.lados[2]:
            return "Equilátero"
        elif len(set(self.lados)) == 2:
            return "Isósceles"
        else:
            return "Escaleno"

tri = Triangulo(3, 4, 5)
perimetro = tri.calcular_perimetro()
tipo_triangulo = tri.tipo()

print(f"Perimetro: {perimetro}")
print(f"Tipo: {tipo_triangulo}")
