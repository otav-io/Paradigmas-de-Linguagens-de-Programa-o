// Interface Animal
abstract class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    abstract void emitirSom();
}

class Mamifero extends Animal {
    public Mamifero(String nome) {
        super(nome);
    }

    public void amamentar() {
        System.out.println(nome + " esta amamentando.");
    }

    @Override
    void emitirSom() {

    }
}

interface Ave {
    void voar();
}

class Morcego extends Mamifero implements Ave {
    public Morcego(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Morcego fazendo ruidos noturnos.");
    }

    @Override
    public void voar() {
        System.out.println(nome + " esta voando.");
    }

    public static void main(String[] args) {
        Morcego morcego = new Morcego("morcego");
        morcego.emitirSom();   
        morcego.amamentar();  
        morcego.voar();     
    }
}