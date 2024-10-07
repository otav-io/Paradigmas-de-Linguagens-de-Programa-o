class Calculadora:
    def somar(self, a, b, c=0):
        return a + b + c
# Exemplo de uso:

def executar_questao10():
    calc = Calculadora()
    print(calc.somar(1, 2)) 
    print(calc.somar(1, 2, 3))  
