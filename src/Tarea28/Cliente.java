package Tarea28;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(), true);

            System.out.println("Juego de adivinar el número (1-100)");

            boolean continuar = true;

            while (continuar) {
                System.out.print("Introduce un número o ADIOS: ");
                String mensaje = teclado.nextLine();

                salida.println(mensaje);

                String respuesta = entrada.readLine();

                if (respuesta == null) {
                    break;
                }
                System.out.println("Servidor: " + respuesta);

                if (mensaje.equalsIgnoreCase("ADIOS") || respuesta.startsWith("ACIERTO")) {
                    continuar = false;
                }
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("No se pudo conectar con el servidor.");
        }
        teclado.close();
    }
}
