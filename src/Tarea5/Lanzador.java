package Tarea5;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Lanzador {

    public static int nivel1(String numero) {
        int codigoSalida = -1;

        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process proceso = pb.start();

            BufferedReader salida = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            BufferedReader error = new BufferedReader(
                    new InputStreamReader(proceso.getErrorStream())
            );

            String linea;

            while ((linea = salida.readLine()) != null) {
                System.out.println(linea);
            }

            while ((linea = error.readLine()) != null) {
                System.out.println(linea);
            }

            codigoSalida = proceso.waitFor();

            salida.close();
            error.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return codigoSalida;
    }

    public static int nivel2(String numero) {
        int codigoSalida = -1;

        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process proceso = pb.start();

            BufferedReader salida = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            BufferedReader error = new BufferedReader(
                    new InputStreamReader(proceso.getErrorStream())
            );

            String linea;

            while ((linea = salida.readLine()) != null) {
                System.out.println("[OK] " + linea);
            }

            while ((linea = error.readLine()) != null) {
                System.out.println("[ERROR] " + linea);
            }

            codigoSalida = proceso.waitFor();

            salida.close();
            error.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return codigoSalida;
    }

    public static int nivel3(String numero) {
        int codigoSalida = -1;

        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process proceso = pb.start();

            BufferedReader salida = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            BufferedReader error = new BufferedReader(
                    new InputStreamReader(proceso.getErrorStream())
            );

            PrintWriter archivoSalida = new PrintWriter(
                    new FileWriter("factor_output.log", true)
            );

            PrintWriter archivoError = new PrintWriter(
                    new FileWriter("factor_error.log", true)
            );

            String linea;

            while ((linea = salida.readLine()) != null) {
                archivoSalida.println(linea);
            }

            while ((linea = error.readLine()) != null) {
                archivoError.println(linea);
            }

            codigoSalida = proceso.waitFor();

            archivoSalida.close();
            archivoError.close();
            salida.close();
            error.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return codigoSalida;
    }

    public static int nivel4(String numero) {
        int codigoSalida = -1;

        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process proceso = pb.start();

            BufferedReader salida = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            BufferedReader error = new BufferedReader(
                    new InputStreamReader(proceso.getErrorStream())
            );

            String linea;
            String resultado = "";

            while ((linea = salida.readLine()) != null) {
                System.out.println(linea);
                resultado = linea;
            }

            while ((linea = error.readLine()) != null) {
                System.out.println(linea);
            }

            codigoSalida = proceso.waitFor();

            if (codigoSalida == 0) {

                String[] partes = resultado.split(":");

                if (partes.length == 2) {

                    String factores = partes[1].trim();

                    if (factores.equals(numero)) {
                        System.out.println("¡" + numero + " es primo!");
                    } else {
                        System.out.println(numero + " no es primo");
                    }
                }
            }

            salida.close();
            error.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return codigoSalida;
    }
}