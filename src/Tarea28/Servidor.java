package Tarea28;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);

            System.out.println("Servidor iniciado en el puerto 5000");

            while (true) {
                Socket cliente = servidor.accept();
                try {
                    BufferedReader entrada = new BufferedReader(
                            new InputStreamReader(cliente.getInputStream()));

                    PrintWriter salida = new PrintWriter(
                            cliente.getOutputStream(), true);

                    Random random = new Random();
                    int numeroSecreto = random.nextInt(100) + 1;
                    int intentos = 0;

                    String mensaje;

                    while ((mensaje = entrada.readLine()) != null) {
                        mensaje = mensaje.trim();
                        if (mensaje.equalsIgnoreCase("ADIOS")) {
                            salida.println("OK Hasta luego");
                            break;
                        }
                        try {
                            int numero = Integer.parseInt(mensaje);

                            if (numero < 1 || numero > 100) {
                                salida.println("ERR Comando no válido");
                            } else {
                                intentos++;

                                if (numero < numeroSecreto) {
                                    salida.println("MAYOR");
                                } else if (numero > numeroSecreto) {
                                    salida.println("MENOR");
                                } else {
                                    salida.println("ACIERTO en " + intentos + " intentos");
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            salida.println("ERR Comando no válido");
                        }
                    }
                } catch (IOException e) {
                } finally {
                    try {
                        cliente.close();
                    } catch (IOException e) {
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor.");
        }
    }
}
