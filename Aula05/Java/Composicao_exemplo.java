// Classe Motor
class Motor {
    private String tipo;
    private int potencia;

    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public void ligar() {
        System.out.println("O motor esta ligado.");
    }

    public void desligar() {
        System.out.println("O motor esta desligado.");
    }
}

class Carro {
    private String marca;
    private String modelo;
    private Motor motor; 
    private Pneu[] pneus;

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = new Motor("Gasolina", 160);
        this.pneus = new Pneu[4];
        for (int i = 0; i < 4; i++) {
            pneus[i] = new Pneu("Pirelli", 18);
        }
    }

    class Pneu {
        private String marca;
        private int tamanho;
    
        public Pneu(String marca, int tamanho) {
            this.marca = marca;
            this.tamanho = tamanho;
        }
    
        public void inflar() {
            System.out.println("O pneu esta inflado.");
        }
    
        public void desinflar() {
            System.out.println("O pneu esta desinflado.");
        }
    }

    public void ligar() {
        motor.ligar();
        System.out.println("carro ligado.");
    }

    public void desligar() {
        motor.desligar();
        System.out.println("carro desligado.");
    }

    public void trocarPneu(int indice, Pneu novoPneu) {
        if (indice >= 0 && indice < 4) {
            pneus[indice] = novoPneu;
            System.out.println("Pneu " + (indice + 1) + " trocado.");
        } else {
            System.out.println("indice de pneu invalido.");
        }
    }
}

//exemplo de uso
public class Composicao_exemplo{
    public static void main(String[] args) {
        Carro carro = new Carro("mitsubishi", "lancer");
        carro.ligar();

        Pneu novoPneu = new Pneu("Michelin", 17);
        carro.trocarPneu(2, novoPneu);

        carro.desligar();
    }
}