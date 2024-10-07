package projetojava;

import java.util.ArrayList;
import java.util.List;

class Empregado {
    String nome;
    String cargo;
    double salario;

    Empregado(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }
}

class Empresa {
    List<Empregado> empregados;

    Empresa() {
        empregados = new ArrayList<>();
    }

    void adicionarEmpregado(Empregado empregado) {
        empregados.add(empregado);
    }
}

public class questao8 {
    public static void main(String[] args) {
        Empregado empregado1 = new Empregado("Matheus", "Desenvolvedor", 3000);
        Empregado empregado2 = new Empregado("Lauane", "RH", 3500);
        Empregado empregado3 = new Empregado("Otavio", "Analista de Dados", 4000);

        Empresa empresa = new Empresa();

        empresa.adicionarEmpregado(empregado1);
        empresa.adicionarEmpregado(empregado2);
        empresa.adicionarEmpregado(empregado3);

        for (Empregado emp : empresa.empregados) {
            System.out.println("Empregado: " + emp.nome + ", Cargo: " + emp.cargo + ", Salario: R$" + emp.salario);
        }
    }
}
