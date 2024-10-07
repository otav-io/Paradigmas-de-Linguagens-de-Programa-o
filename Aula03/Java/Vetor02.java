//Exemplo de Vetor 2 em Java - calculando a mÃ©dia dos elementos do vetor
//Mais a o maior elemento do vetor e o menor elemento do vetor.


public class Vetor02 {
    public static void main(String[] args) {

        int[] vetor = {5, 12, 7, 20, 15, 8, 3, 11, 6, 9};

        System.out.println("Média: " + calcularMedia(vetor));
        System.out.println("Maior valor: " + encontrarMaior(vetor));
        System.out.println("Menor valor: " + encontrarMenor(vetor));
    }

    public static double calcularMedia(int[] vetor) {
        int soma = 0;
        for (int valor : vetor) {
            soma += valor;
        }
        return (double) soma / vetor.length;
    }

    public static int encontrarMaior(int[] vetor) {
        int maior = vetor[0];
        for (int valor : vetor) {
            if (valor > maior) {
                maior = valor;
            }
        }
        return maior;
    }

    public static int encontrarMenor(int[] vetor) {
        int menor = vetor[0];
        for (int valor : vetor) {
            if (valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }
}
