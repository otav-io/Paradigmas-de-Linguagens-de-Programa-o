package projetojava;

class Motor {
    int potencia;

    Motor(int potencia) {
        this.potencia = potencia;
    }
}

class Carro3 {
    String marca;
    String modelo;
    int ano;
    Motor motor;

    Carro3(String marca, String modelo, int ano, int potenciaMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.motor = new Motor(potenciaMotor);
    }

    String detalhesCarro() {
        return marca + " " + modelo + " (" + ano + ") com motor de " + motor.potencia + " CV.";
    }
}

public class questao6 {
    public static void main(String[] args) {
        Carro3 carro1 = new Carro3("Toyota", "hilux", 2024, 204);
        Carro3 carro2 = new Carro3("Kya", "sorento", 2015, 194);
        Carro3 carro3 = new Carro3("Mitsubishi", "lancer", 2012, 160);

        System.out.println(carro1.detalhesCarro());
        System.out.println(carro2.detalhesCarro());
        System.out.println(carro3.detalhesCarro());
    }
}
