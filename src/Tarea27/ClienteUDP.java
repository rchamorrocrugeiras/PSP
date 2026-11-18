package Tarea27;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            DatagramSocket socket = new DatagramSocket();

            socket.setSoTimeout(2000);

            InetAddress servidor = InetAddress.getByName("localhost");

            System.out.println("Introduce varias palabras separadas por comas:");
            String mensaje = teclado.nextLine();

            byte[] datos = mensaje.getBytes();

            DatagramPacket paquete = new DatagramPacket(datos, datos.length, servidor, 5000);

            boolean recibido = false;

            for (int intento = 1; intento <= 3 && !recibido; intento++) {
                try {
                    System.out.println("Envio número " + intento);

                    socket.send(paquete);

                    byte[] respuesta = new byte[1024];

                    DatagramPacket paqueteRespuesta =
                            new DatagramPacket(respuesta, respuesta.length);

                    socket.receive(paqueteRespuesta);

                    String resultado = new String(
                            paqueteRespuesta.getData(),
                            0,
                            paqueteRespuesta.getLength());

                    String[] partes = resultado.split(";");

                    System.out.println("Palabra más larga: " + partes[0]);
                    System.out.println("Longitud: " + partes[1]);

                    recibido = true;
                } catch (SocketTimeoutException e) {
                    System.out.println("No se recibió respuesta.");
                }
            }

            if (!recibido) {
                System.out.println("Servidor no disponible");
            }

            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        teclado.close();
    }
}