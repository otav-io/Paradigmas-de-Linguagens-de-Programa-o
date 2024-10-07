// faça um programa em java que receba 6 numeros inteiros e mostre:
// Os numeros pares digitados; 
// A soma dos numeros pares digitados; 
// Os numeros   Ä±mpares digitados;
// A quantidade de numeros  impares 

import java.util.Scanner;

public class Vetor04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[6];

        System.out.println("Digite 6 números inteiros:");
        for (int i = 0; i < 6; i++) {
            numeros[i] = scanner.nextInt();
        }

        mostrarNumerosPares(numeros);
        mostrarNumerosImpares(numeros);
    }

    public static void mostrarNumerosPares(int[] numeros) {
        int somaPares = 0;
        System.out.print("Números pares digitados: ");
        for (int num : numeros) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
                somaPares += num;
            }
        }
        System.out.println("\nSoma dos números pares: " + somaPares);
    }

    public static void mostrarNumerosImpares(int[] numeros) {
        int quantidadeImpares = 0;
        System.out.print("Números ímpares digitados: ");
        for (int num : numeros) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
                quantidadeImpares++;
            }
        }
        System.out.println("\nQuantidade de números ímpares: " + quantidadeImpares);
    }
}
