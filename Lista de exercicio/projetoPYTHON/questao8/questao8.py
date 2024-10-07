class Empregado:
    def __init__(self, nome, cargo, salario):
        self.nome = nome
        self.cargo = cargo
        self.salario = salario

class Empresa:
    def __init__(self):
        self.empregados = []

    def adicionar_empregado(self, empregado):
        self.empregados.append(empregado)

def executar_questao8():
    empregado1 = Empregado("Matheus", "Desenvolvedor", 3000)
    empregado2 = Empregado("Lauane", "RH", 3500)
    empregado3 = Empregado("Otavio", "Analista de Dados", 4000)

    empresa = Empresa()

    empresa.adicionar_empregado(empregado1)
    empresa.adicionar_empregado(empregado2)
    empresa.adicionar_empregado(empregado3)

    for emp in empresa.empregados:
        print(f"Empregado: {emp.nome}, Cargo: {emp.cargo}, Salario: R${emp.salario}")

