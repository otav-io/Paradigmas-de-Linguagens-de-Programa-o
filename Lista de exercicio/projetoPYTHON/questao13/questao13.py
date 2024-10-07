class Matematica:
    @staticmethod
    def fatorial(n):
        if n == 0:
            return 1
        return n * Matematica.fatorial(n-1)

#Exemplo de uso:

def executar_questao13():
    print(f"Fatorial de 5: {Matematica.fatorial(5)}")
