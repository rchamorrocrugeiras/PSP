package Tarea27;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);

            System.out.println("Servidor UDP iniciado");

            while(true) {
                byte[] datos = new byte[1024];

                DatagramPacket paquete = new DatagramPacket(datos, datos.length);

                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength());

                String[] palabras = mensaje.split(",");

                String mayor = "";

                for (String palabra : palabras) {
                    if (palabra.length() > mayor.length()) {
                        mayor = palabra;
                    }
                }

                String respuesta = mayor + ";" + mayor.length();

                byte[] respuestaBytes = respuesta.getBytes();

                DatagramPacket paqueteRespuesta =
                        new DatagramPacket(respuestaBytes, respuestaBytes.length, paquete.getAddress(), paquete.getPort());

                socket.send(paqueteRespuesta);

                System.out.println("Palabra más larga: " + mayor);
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
