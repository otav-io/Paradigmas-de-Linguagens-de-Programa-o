package projetojava;

class Singleton {
    private static Singleton instanciaUnica;

    private Singleton() {
    }

    public static Singleton getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Singleton();
        }
        return instanciaUnica;
    }

    public void mostrarMensagem() {
        System.out.println("Exemplo de Singleton");
    }
}

public class questao13 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstancia();
        Singleton singleton2 = Singleton.getInstancia();

        singleton1.mostrarMensagem();

        if (singleton1 == singleton2) {
            System.out.println("Ambos os objetos são a mesma instância.");
        }
    }
}
