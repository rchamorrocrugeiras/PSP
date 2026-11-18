package EstructuraAntiguoExamen;

import java.util.Scanner;

public class Ejercicio2 {

    // 1. Variable compartida por todos los hilos
    static int total = 0;

    // Metodo seguro para que los hilos sumen al total sin pisarse
    public static synchronized void sumarAlTotal() {
        total++;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una cadena de texto:");
        String texto = sc.nextLine();

        // 2. Creamos los hilos directamente (cambia los caracteres según el enunciado)
        HiloContador h2 = new HiloContador(texto, '2');
        HiloContador h4 = new HiloContador(texto, '4');
        HiloContador h6 = new HiloContador(texto, '6');
        HiloContador h8 = new HiloContador(texto, '8');

        // 3. Los arrancamos todos a la vez (concurrencia)
        h2.start();
        h4.start();
        h6.start();
        h8.start();

        // 4. Esperamos a que todos terminen
        h2.join();
        h4.join();
        h6.join();
        h8.join();

        // 5. Imprimimos los resultados
        System.out.println("Resultados:");
        System.out.println("Total de dígitos pares encontrados: " + total);
        System.out.println("Frecuencia de cada dígito par:");
        System.out.println("Digito 2: " + h2.contador);
        System.out.println("Digito 4: " + h4.contador);
        System.out.println("Digito 6: " + h6.contador);
        System.out.println("Digito 8: " + h8.contador);
    }

    // Clase del hilo súper sencilla
    static class HiloContador extends Thread {
        String texto;
        char letraBuscada;
        int contador = 0; // Guarda las veces que aparece su carácter

        public HiloContador(String texto, char letraBuscada) {
            this.texto = texto;
            this.letraBuscada = letraBuscada;
        }

        @Override
        public void run() {
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == letraBuscada) {
                    contador++;
                    sumarAlTotal(); // Suma 1 a la variable global compartida
                }
            }
        }
    }
}