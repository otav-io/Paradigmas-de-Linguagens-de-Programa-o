#criar a classe pessoa com nome e idade
#associar uma classe endereço as pessoas onde tera alocado informações de rua, cidade, estado, cep 
#criar  uma classe empresa com nome, cnpj, e funcionarios
#fazer com que a as pessoas adicionadas sejam contratada pela empresa

class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade
        self._endereco = None 

    def set_endereco(self, endereco):
        self._endereco = endereco

    def get_endereco(self):
        return self._endereco

    def exibir_informacoes(self):
        print(f"Nome: {self.nome} | Idade: {self.idade}")
        if self._endereco is not None:
            print("Detalhes do Endereço:")
            self._endereco.exibir_endereco()
        else:
            print("Endereço não definido.")

class Endereco:
    def __init__(self, rua, cidade, estado, cep):
        self._rua = rua
        self._cidade = cidade
        self._estado = estado
        self._cep = cep

    def exibir_endereco(self):
        print(f"Rua: {self._rua}, Cidade: {self._cidade}, Estado: {self._estado}, CEP: {self._cep}")

class Empresa:
    def __init__(self, nome, cnpj):
        self._nome = nome
        self._cnpj = cnpj
        self._funcionarios = []

    def adicionar_funcionario(self, funcionario):
        self._funcionarios.append(funcionario)

    def mostrar_funcionarios(self):
        print(f"Funcionários da empresa {self._nome}:")
        if not self._funcionarios:
            print("Nenhum funcionário contratado.")
        else:
            for funcionario in self._funcionarios:
                print(funcionario.nome)

# Exemplo de uso
end1 = Endereco("loteamento luis carlos de mendonça", "goiana", "pernambuco", "55900-000")
pessoa1 = Pessoa("otavio", 20)
pessoa1.set_endereco(end1)

end2 = Endereco("rua pal ferro", "joao pessoa", "paraiba", "58010-030")
pessoa2 = Pessoa("Fernanda", 21)
pessoa2.set_endereco(end2)

empresa = Empresa("empresa", "98765432100001")
empresa.adicionar_funcionario(pessoa1)
empresa.adicionar_funcionario(pessoa2)

empresa.mostrar_funcionarios()
