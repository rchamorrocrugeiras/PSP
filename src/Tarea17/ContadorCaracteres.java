package Tarea17;

import java.util.Scanner;

public class ContadorCaracteres implements Runnable {

    private char consonante;
    private String texto;
    private int contador;
    private static int total = 0;

    public ContadorCaracteres(char consonante, String texto) {
        this.consonante = consonante;
        this.texto = texto;
        this.contador = 0;
    }

    public void run() {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == consonante) {
                contador++;
                }
            }
        }

        System.out.println("La consonante '" + consonante + "' aparece " + contador + " veces.");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        char[] consonantes = new char[5];


    }
}
