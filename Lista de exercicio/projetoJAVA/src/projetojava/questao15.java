package projetojava;

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class ContaBancaria {
    private double saldo;
    private String titular;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double quantia) {
        saldo += quantia;
    }

    public void sacar(double quantia) throws SaldoInsuficienteException {
        if (quantia > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }
        saldo -= quantia;
    }

    public double exibirSaldo() {
        return saldo;
    }
}

public class questao15 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Maria", 500);

        try {
            conta.sacar(600); 
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo atual: R$" + conta.exibirSaldo());
    }
}
