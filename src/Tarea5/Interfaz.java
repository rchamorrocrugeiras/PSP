package Tarea5;

import java.util.Scanner;

public class Interfaz {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Qué nivel quieres usar René? (1, 2, 3 o 4):");
        System.out.print("> ");
        int nivel = teclado.nextInt();
        teclado.nextLine();

        if (nivel < 1 || nivel > 4) {
            System.out.println("Nivel no válido.");
            teclado.close();
            return;
        }

        while (true) {

            System.out.println("René, introduce un número (o 'salir' para terminar):");
            System.out.print("> ");

            String numero = teclado.nextLine();

            if (numero.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa");
                break;
            }

            int codigoSalida;

            switch (nivel) {

                case 1:
                    codigoSalida = Lanzador.nivel1(numero);
                    break;

                case 2:
                    codigoSalida = Lanzador.nivel2(numero);
                    break;

                case 3:
                    codigoSalida = Lanzador.nivel3(numero);
                    break;

                case 4:
                    codigoSalida = Lanzador.nivel4(numero);
                    break;

                default:
                    codigoSalida = -1;
            }

            System.out.println("Operación completada René. Código de salida: "
                    + codigoSalida);
        }

        teclado.close();
    }
}