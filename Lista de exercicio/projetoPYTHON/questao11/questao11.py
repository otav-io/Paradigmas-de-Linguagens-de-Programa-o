from abc import ABC, abstractmethod

class Funcionario(ABC):
    @abstractmethod
    def calcularSalario(self):
        pass

class FuncionarioHorista(Funcionario):
    def calcularSalario(self, horas, taxa):
        return horas * taxa

class FuncionarioAssalariado(Funcionario):
    def calcularSalario(self, salario_fixo):
        return salario_fixo

def executar_questao11():
    horista = FuncionarioHorista()
    assalariado = FuncionarioAssalariado()
    
    print(f"Salario Horista: {horista.calcularSalario(160, 20)}")
    print(f"Salario Assalariado: {assalariado.calcularSalario(3000)}")
