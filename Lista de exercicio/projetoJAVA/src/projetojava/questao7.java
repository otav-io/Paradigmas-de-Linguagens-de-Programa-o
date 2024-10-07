package projetojava;

import java.util.ArrayList;
import java.util.List;

class Professor {
    String nome;
    List<Escola> escolas;

    Professor(String nome) {
        this.nome = nome;
        this.escolas = new ArrayList<>();
    }

    void adicionarEscola(Escola escola) {
        escolas.add(escola);
    }
}

class Escola {
    String nome;
    List<Professor> professores;

    Escola(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
    }

    void adicionarProfessor(Professor professor) {
        professores.add(professor);
        professor.adicionarEscola(this);
    }
}

public class questao7 {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Ricardo");
        Professor professor2 = new Professor("Douglas");
        Professor professor3 = new Professor("Leonardo");

        Escola escolaA = new Escola("Escola A");
        Escola escolaB = new Escola("Escola B");

        escolaA.adicionarProfessor(professor1);
        escolaB.adicionarProfessor(professor2);
        escolaB.adicionarProfessor(professor3);
        escolaA.adicionarProfessor(professor3);

        System.out.println("Professores na Escola A:");
        for (Professor prof : escolaA.professores) {
            System.out.println(prof.nome);
        }

        System.out.println("\nProfessores na Escola B:");
        for (Professor prof : escolaB.professores) {
            System.out.println(prof.nome);
        }
    }
}
