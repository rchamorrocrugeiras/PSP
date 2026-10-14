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
                synchronized (ContadorCaracteres.class) {
                    total++;
                }
            }
        }
        System.out.println("La consonante '" + consonante + "' aparece " + contador + " veces.");
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);

        char[] consonantes = new char[5];

        for (int i = 0; i < consonantes.length; i++) {
            System.out.print("Introduce la consonante " + (i + 1) + ": ");
            consonantes[i] = teclado.next().charAt(0);
        }

        teclado.nextLine();

        System.out.print("Introduce el texto: ");
        String texto = teclado.nextLine();

        texto = texto.repeat(2000);

        Thread[] hilos = new Thread[5];

        for (int i = 0; i < consonantes.length; i++) {
            ContadorCaracteres contador = new ContadorCaracteres(consonantes[i], texto);
            hilos[i] = new Thread(contador);
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].join();
        }

        System.out.println("Total de apariciones: " + ContadorCaracteres.total);

        teclado.close();
    }
}