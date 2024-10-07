package projetojava;

interface Pagavel {
    void realizarPagamento();
}

class Funcionario implements Pagavel {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento de R$" + salario + " realizado para o funcionário " + nome);
    }
}

class Fornecedor implements Pagavel {
    private String nome;
    private double valorFatura;

    public Fornecedor(String nome, double valorFatura) {
        this.nome = nome;
        this.valorFatura = valorFatura;
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento de R$" + valorFatura + " realizado para o fornecedor " + nome);
    }
}

public class questao12 {
    public static void processarPagamentos(Pagavel[] pagaveis) {
        for (Pagavel pagavel : pagaveis) {
            pagavel.realizarPagamento();
        }
    }

    public static void main(String[] args) {
        Pagavel[] pagaveis = {
            new Funcionario("Juliana", 3000),
            new Funcionario("Rodrigo", 4000),
            new Fornecedor("ABC Ltda", 1500)
        };

        processarPagamentos(pagaveis);
    }
}
