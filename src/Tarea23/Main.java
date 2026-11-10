package Tarea23;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            InetAddress equipo = InetAddress.getLocalHost();

            System.out.println("Nombre del equipo: " + equipo.getHostName());
            System.out.println("IP del equipo " + equipo.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("Error al obtener el equipo local.");
        }

        String dominio;

        do {
            System.out.println("Introduce un dominio (o salir): ");
            dominio = scanner.nextLine();

            if (!dominio.equalsIgnoreCase("salir")) {
                try {
                    InetAddress[] ips = InetAddress.getAllByName(dominio);

                    System.out.println("Direcciones IP de " + dominio + ":");

                    for (InetAddress ip : ips) {
                        if (ip.getAddress().length == 4) {
                            System.out.println("IPv4: " + ip.getHostAddress());
                        } else {
                            System.out.println("IPv6 " + ip.getHostAddress());
                        }
                    }
                } catch (UnknownHostException e) {
                    System.out.println("Error: dominio no encontrado.");
                }
            }
        } while (!dominio.equalsIgnoreCase("salir"));

        System.out.println("Programa finalizado.");

        scanner.close();
    }
}
