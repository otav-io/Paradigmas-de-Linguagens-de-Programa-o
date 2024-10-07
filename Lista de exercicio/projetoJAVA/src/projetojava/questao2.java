package projetojava;

class Carro1 {
    String marca;
    String modelo;
    int ano;
    int velocidade;

    Carro1(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0;
    }

    void acelerar() {
        velocidade += 10;
    }

    void frear() {
        velocidade -= 10;
    }

    String exibirVelocidade() {
        return "Velocidade atual: " + velocidade + " km/h";
    }
}

public class questao2 {
    public static void main(String[] args) {
        Carro1 carro = new Carro1("Mitsubishi", "lancer", 2012);
        carro.acelerar();
        System.out.println(carro.exibirVelocidade());
        carro.acelerar();
        System.out.println(carro.exibirVelocidade());
        carro.frear();
        System.out.println(carro.exibirVelocidade());
        carro.frear();
        System.out.println(carro.exibirVelocidade());
    }
}
