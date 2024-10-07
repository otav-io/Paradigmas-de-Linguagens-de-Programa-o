class Professor:
    def __init__(self, nome):
        self.nome = nome
        self.escolas = []

    def adicionar_escola(self, escola):
        self.escolas.append(escola)

class Escola:
    def __init__(self, nome):
        self.nome = nome
        self.professores = []

    def adicionar_professor(self, professor):
        self.professores.append(professor)
        professor.adicionar_escola(self)

# Exemplo de uso:

def executar_questao7():
    professor1 = Professor("Ricardo")
    professor2 = Professor("Douglas")
    professor3 = Professor("Leonardo")

    escolaA = Escola("escola A")
    escolaB = Escola("escola B")
    
    escolaA.adicionar_professor(professor1)
    escolaB.adicionar_professor(professor2)
    escolaB.adicionar_professor(professor3)
    escolaA.adicionar_professor(professor3)

    print("Professores na Escola A:")
    for prof in escolaA.professores:
        print(prof.nome)

    print("\nProfessores na Escola B:")
    for prof in escolaB.professores:
        print(prof.nome)
