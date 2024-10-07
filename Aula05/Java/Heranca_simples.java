class Animal {
    protected String especie;
    protected String nome;

    public Animal(String especie, String nome) {
        this.especie = especie;
        this.nome = nome;
    }

    public String emitirSom() {
        return ""; 
    }
}

class Gato extends Animal {
    public Gato(String nome) {
        super("Gato", nome);
    }
    @Override
    public String emitirSom() {
        return "Miau";
    }
}

class Cachorro extends Animal {
    public Cachorro(String nome) {
        super("Cachorro", nome);
    }
    @Override
    public String emitirSom() {
        return "Au Au";
    }
}


//Exemplo de uso
public class Heranca_simples {
    public static void main(String[] args) {
        Animal cachorro = new Cachorro("Anakin");
        Animal gato = new Gato("Yummi");

        System.out.println(cachorro.nome + " fala: " + cachorro.emitirSom());
        System.out.println(gato.nome + " fala: " + gato.emitirSom());
    }
}
