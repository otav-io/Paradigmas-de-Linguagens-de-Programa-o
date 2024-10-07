class Animal:
    def som(self):
        raise NotImplementedError("Método deve ser implementado na subclasse")

class Cachorro(Animal):
    def som(self):
        return "Au Au"

class Gato(Animal):
    def som(self):
        return "Miau"

class Pato(Animal):
    def som(self):
        return "Quack"

class pinto(Animal):
    def som(self):
        return "piu"

def fazer_som(animais):
    for animal in animais:
        print(f"{animal.__class__.__name__}: {animal.som()}")

def executar_questao5():
    animais = [Cachorro(), Gato(), Pato(), pinto()]
    fazer_som(animais)