package projetojava;

abstract class Animal {
    abstract String som();
}

class Cachorro extends Animal {
    @Override
    String som() {
        return "Au Au";
    }
}

class Gato extends Animal {
    @Override
    String som() {
        return "Miau";
    }
}

class Pato extends Animal {
    @Override
    String som() {
        return "Quack";
    }
}

class Pinto extends Animal {
    @Override
    String som() {
        return "Piu";
    }
}

public class questao5 {
    public static void fazerSom(Animal[] animais) {
        for (Animal animal : animais) {
            System.out.println(animal.getClass().getSimpleName() + ": " + animal.som());
        }
    }

    public static void main(String[] args) {
        Animal[] animais = {new Cachorro(), new Gato(), new Pato(), new Pinto()};
        fazerSom(animais);
    }
}
