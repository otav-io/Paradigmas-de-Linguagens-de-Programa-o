class Produto:
    def __init__(self, preco):
        self.preco = preco

    def __add__(self, outro):
        return self.preco + outro.preco

def executar_questao12():
    p1 = Produto(100)
    p2 = Produto(200)
    
    print(f"Soma dos precos: R${p1 + p2}")
