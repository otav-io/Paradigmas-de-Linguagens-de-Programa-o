class Cafeteira {
    public void moerGraos() {
        System.out.println("Moendo graos de cafe");
    }

    public void fazerCafe() {
        System.out.println("Fazendo cafe");
    }
}

class Chaleira {
    public void ferverAgua() {
        System.out.println("Fervendo agua");
    }

    public void fazerCha() {
        System.out.println("Fazendo cha");
    }
}

class BebidasFacade {
    private Cafeteira cafeteira;
    private Chaleira chaleira;

    public BebidasFacade() {
        this.cafeteira = new Cafeteira();
        this.chaleira = new Chaleira();
    }

    public void prepararCafe() {
        System.out.println("\nPreparando cafe...");
        cafeteira.moerGraos();
        cafeteira.fazerCafe();
    }

    public void prepararCha() {
        System.out.println("\nPreparando cha...");
        chaleira.ferverAgua();
        chaleira.fazerCha();
    }
}

//Exemplo de uso
public class Padrao_facade {
    public static void main(String[] args) {
        BebidasFacade facade = new BebidasFacade();
        facade.prepararCafe();
        facade.prepararCha();
    }
}
