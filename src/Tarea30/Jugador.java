package Tarea30;

import java.net.Socket;

public class Jugador extends Thread {
    private Socket cliente;

    public Jugador(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {

    }
}
