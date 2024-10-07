package projetojava;

abstract class Animal {
    abstract String som();
    abstract String comportamento();
}

class Cachorro extends Animal {
    @Override
    String som() {
        return "Au Au";
    }

    @Override
    String comportamento() {
        return "O cachorro corre atrás do próprio rabo.";
    }
}

class Gato extends Animal {
    @Override
    String som() {
        return "Miau";
    }

    @Override
    String comportamento() {
        return "O gato destrói toda a casa fingindo que nada aconteceu.(maligno)";
    }
}

class Pato extends Animal {
    @Override
    String som() {
        return "Quack";
    }

    @Override
    String comportamento() {
        return "O pato nada no lago.";
    }
}

class Pinto extends Animal {
    @Override
    String som() {
        return "Piu";
    }

    @Override
    String comportamento() {
        return "O pinto sai do ovo.";
    }
}

public class questao4 {
    public static void main(String[] args) {
        Animal[] animais = {new Cachorro(), new Gato(), new Pato(), new Pinto()};

        for (Animal animal : animais) {
            System.out.println(animal.getClass().getSimpleName() + ":");
            System.out.println("Som: " + animal.som());
            System.out.println("Comportamento: " + animal.comportamento() + "\n");
        }
    }
}
