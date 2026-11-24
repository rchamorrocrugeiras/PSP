package Tarea30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Jugador extends Thread {
    private Socket cliente;

    public Jugador(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

        } catch (IOException e) {
            System.out.println("Error con el jugador.");
        }
    }
}
