package projetojava;

 class Carro {
    String marca;
    String modelo;
    int ano;

    Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    String exibirDetalhes() {
        return marca + " " + modelo + " (" + ano + ")";
    }
}

public class questao1 {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Toyota", "hilux", 2024);
        Carro carro2 = new Carro("Kya", "sorento", 2015);
        Carro carro3 = new Carro("Mitsubishi", "lancer", 2012);

        Carro[] carros = {carro1, carro2, carro3};

        for (Carro carro : carros) {
            System.out.println(carro.exibirDetalhes());
        }
    }
}
