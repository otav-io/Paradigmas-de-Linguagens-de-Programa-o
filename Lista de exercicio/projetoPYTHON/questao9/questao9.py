from abc import ABC, abstractmethod

class Imprimivel(ABC):
    @abstractmethod
    def imprimir(self):
        pass

class Relatorio(Imprimivel):
    def imprimir(self):
        return "Imprimindo relatorio..."

class Contrato(Imprimivel):
    def imprimir(self):
        return "Imprimindo contrato..."

def executar_questao9():
    relatorio = Relatorio()
    contrato = Contrato()
    
    print(relatorio.imprimir())
    print(contrato.imprimir())
