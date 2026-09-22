package Tarea5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lanzador {

    public static int ejecutarFactor(String numero) {

        int codigoSalida = -1;

        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process proceso = pb.start();
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            BufferedReader errores = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            codigoSalida = proceso.waitFor();

            lector.close();
            errores.close();
        }

        catch (Exception e) {
            System.out.println("Error al ejecutar el factor", e.getMessage());
        }

        return codigoSalida;
    }
}
