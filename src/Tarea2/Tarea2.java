package Tarea2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tarea2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el nombre o ruta del archivo: ");
        String ruta = teclado.nextLine();

        File archivo = new File(ruta);

        try {
            ProcessBuilder proceso = new ProcessBuilder("gedit", ruta);
            proceso.start();

            if (archivo.exists()) {
                System.out.println("Abriendo archivo existente...");
            } else {
                System.out.println("El archivo no existe. Se abrirá el editor para crearlo.");
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el editor.");
            e.printStackTrace();
        }

        teclado.close();
    }
}