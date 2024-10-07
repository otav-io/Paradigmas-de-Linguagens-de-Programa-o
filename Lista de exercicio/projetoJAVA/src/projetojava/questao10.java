package projetojava;

class Calculadora {
    
	public int somar(int a, int b) {
        return somar(a, b, 0);
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }

public class questao10 {
	public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        int resultado1 = calc.somar(2, 3);
        System.out.println("Resultado da soma de 2 e 3: " + resultado1);

        int resultado2 = calc.somar(2, 3, 4);
        System.out.println("Resultado da soma de 2, 3 e 4: " + resultado2);
    }
}
}
