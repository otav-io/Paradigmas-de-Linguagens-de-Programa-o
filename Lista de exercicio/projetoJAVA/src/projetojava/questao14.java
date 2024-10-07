package projetojava;

class Configuracao {
    private static Configuracao instancia;

    private Configuracao() {
    }

    public static Configuracao getInstancia() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }
}


public class questao14 {
    public static void main(String[] args) {
        Configuracao config1 = Configuracao.getInstancia();
        Configuracao config2 = Configuracao.getInstancia();

        System.out.println(config1 == config2);
    }
}
