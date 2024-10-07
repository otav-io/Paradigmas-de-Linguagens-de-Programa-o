package projetojava;

class ContaBancaria2 {
    private double saldo;
    String titular;

    ContaBancaria2(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    void depositar(double quantia) {
        saldo += quantia;
    }

    void sacar(double quantia) {
        if (quantia <= saldo) {
            saldo -= quantia;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    String exibirSaldo() {
        return "Saldo atual: R$" + saldo;
    }
}

public class questao3 {
    public static void main(String[] args) {
        ContaBancaria2 conta = new ContaBancaria2("Maria", 500);
        conta.depositar(200);
        System.out.println(conta.exibirSaldo());
        conta.sacar(100);
        System.out.println(conta.exibirSaldo());
        conta.sacar(700);
    }
}
