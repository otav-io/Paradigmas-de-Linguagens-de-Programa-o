package projetojava;

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class ContaBancaria1 {
    private double saldo;

    public ContaBancaria1(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado: " + valor + ". Saldo restante: " + saldo);
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado: " + valor + ". Saldo atual: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}

public class questao9 {
    public static void main(String[] args) {
        ContaBancaria1 conta = new ContaBancaria1(500);

        try {
            conta.depositar(200);
            conta.sacar(800); 
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo final: " + conta.getSaldo());
    }
}
