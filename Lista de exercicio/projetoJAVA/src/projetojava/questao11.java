package projetojava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class questao11 {
    public static void main(String[] args) {
        String caminhoArquivo = "saida.txt";
        String conteudo = "Este é o conteúdo que será gravado no arquivo.";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            escritor.write(conteudo);
            System.out.println("Conteúdo gravado com sucesso no arquivo " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }
}
