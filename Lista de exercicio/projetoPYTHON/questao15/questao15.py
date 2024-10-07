class SaldoInsuficienteException(Exception):
    def __init__(self, mensagem="Saldo insuficiente para realizar o saque."):
        self.mensagem = mensagem
        super().__init__(self.mensagem)

class ContaBancaria:
    def __init__(self, titular, saldo_inicial):
        self.__saldo = saldo_inicial
        self.titular = titular

    def depositar(self, quantia):
        self.__saldo += quantia

    def sacar(self, quantia):
        if quantia > self.__saldo:
            raise SaldoInsuficienteException()
        self.__saldo -= quantia

    def exibir_saldo(self):
        return f"Saldo atual: R${self.__saldo}"

def executar_questao15():
    conta = ContaBancaria("Maria", 500)
    
    try:
        conta.sacar(600)
    except SaldoInsuficienteException as e:
        print(e)

    print(conta.exibir_saldo())
