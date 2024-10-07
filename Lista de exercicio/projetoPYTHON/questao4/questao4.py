class Animal:
    def som(self):
        raise NotImplementedError("Método deve ser implementado na subclasse")

    def comportamento(self):
        raise NotImplementedError("Método deve ser implementado na subclasse")

class Cachorro(Animal):
    def som(self):
        return "Au Au"

    def comportamento(self):
        return "O cachorro corre atras do proprio rabo."

class Gato(Animal):
    def som(self):
        return "Miau"

    def comportamento(self):
        return "O gato destroi toda a casa fingindo que nada aconteceu (bicho maligno)."

class Pato(Animal):
    def som(self):
        return "Quack"

    def comportamento(self):
        return "O pato nada no lago."

class pinto(Animal):
    def som(self):
        return "piu"

    def comportamento(self):    
        return "o pinto sai do ovo"

def executar_questao4():
    animais = [Cachorro(), Gato(), Pato(), pinto()]

    for animal in animais:
        print(f"{animal.__class__.__name__}:")
        print(f"Som: {animal.som()}")
        print(f"Comportamento: {animal.comportamento()}\n")
