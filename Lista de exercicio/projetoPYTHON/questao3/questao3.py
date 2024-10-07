class ContaBancaria:
    def __init__(self, titular, saldo_inicial):
        self.__saldo = saldo_inicial
        self.titular = titular

    def depositar(self, quantia):
        self.__saldo += quantia

    def sacar(self, quantia):
        if quantia <= self.__saldo:
            self.__saldo -= quantia
        else:
            print("Saldo insuficiente")

    def exibir_saldo(self):
        return f"Saldo atual: R${self.__saldo}"

#Exemplo de uso:

def executar_questao3():
    conta = ContaBancaria("Maria", 500)
    conta.depositar(200)
    print(conta.exibir_saldo())
    conta.sacar(100)
    print(conta.exibir_saldo())
    conta.sacar(700) 