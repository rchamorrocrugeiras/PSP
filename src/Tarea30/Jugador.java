package Tarea30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Jugador extends Thread {
    private Socket cliente;
    static int record = 999;
    static String nombreRecord = "";

    public Jugador(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            String mensaje = entrada.readLine();

            if (mensaje == null || !mensaje.startsWith("HOLA ")) {
                salida.println("ERR Identificate con HOLA");
                return;
            }

            String nombre = mensaje.substring(5);

            salida.println("OK Hola, " + nombre);

            Random random = new Random();
            int numeroSecreto = random.nextInt(100) + 1;
            int intentos = 0;

            while ((mensaje = entrada.readLine()) != null) {
                mensaje = mensaje.trim();

                if (mensaje.equalsIgnoreCase("ADIOS")) {
                    salida.println("OK Hasta luego");
                    break;
                }

                if (mensaje.equalsIgnoreCase("RECORD")) {

                    if (record == 999) {
                        salida.println("OK Todavía no hay récord");
                    } else {
                        salida.println("OK Récord: " + record + " intentos (" + nombreRecord + ")");
                    }
                } else {
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

                                synchronized (Jugador.class) {
                                    if (intentos < record) {
                                        record = intentos;
                                        nombreRecord = nombre;
                                    }
                                }

                                break;
                            }
                        }
                    } catch (NumberFormatException e) {
                        salida.println("ERR Comando no válido");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error con el jugador.");
        }
    }
}
