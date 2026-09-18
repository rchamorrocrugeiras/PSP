package Tarea1;

import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;

public class InformeSistema {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        int procesadores = runtime.availableProcessors();

        System.out.println("PROCESADORES");
        System.out.println("==============================");
        System.out.println("Disponibles JVM: " + procesadores);

        System.out.println();
        System.out.println("MEMORIA · ANTES");
        System.out.println("==============================");

        long total = runtime.totalMemory();
        long libre = runtime.freeMemory();
        long maximo = runtime.maxMemory();

        long uso = total - libre;
        long usoAntes = uso;
        long mib = 1024 * 1024;

        long totalMiB = total / mib;
        long libreMiB = libre / mib;
        long usoMiB = uso / mib;
        long maximoMiB = maximo / mib;

        long porcentaje = uso * 100 / total;

        System.out.println("Total reservada: " + totalMiB + " MiB");
        System.out.println("Libre: " + libreMiB + " MiB");
        System.out.println("En uso: " + usoMiB + " (" + porcentaje + " % de la total)");
        System.out.println("Máxima (-Xmx): " + maximoMiB + " MiB");

        long[] reservado = new long[8 * 1024 * 1024];

        System.out.println();
        System.out.println("MEMORIA · DESPUÉS DE RESERVAR 64 MIB");
        System.out.println("==============================");

        long totalDespues = runtime.totalMemory();
        long libreDespues = runtime.freeMemory();
        long maximoDespues = runtime.maxMemory();

        long usoDespues = totalDespues - libreDespues;

        long totalDespuesMiB = totalDespues / mib;
        long libreDespuesMiB = libreDespues / mib;
        long usoDespuesMiB = usoDespues / mib;
        long maximoDespuesMiB = maximoDespues / mib;

        long porcentajeDespues = usoDespues * 100 / totalDespues;

        System.out.println("Total reservada: " + totalDespuesMiB + " MiB");
        System.out.println("Libre: " + libreDespuesMiB + " MiB");
        System.out.println("En uso: " + usoDespuesMiB + " MiB (" + porcentajeDespues + " % de la total)");
        System.out.println("Máxima (-Xmx): " + maximoDespuesMiB + " MiB");

        long incremento = usoDespues - usoAntes;
        long incrementoMiB = incremento / mib;

        System.out.println("Incremento en uso: " + incrementoMiB
                + " MiB (el array sigue en memoria: reservado[0] = "
                + reservado[0] + ")");

        System.out.println();
        System.out.println("SISTEMA");
        System.out.println("==============================");

        String sistema = System.getProperty("os.name");
        String separador = System.getProperty("file.separator");
        String directorioPersonal = System.getProperty("user.home");

        String ruta = directorioPersonal
                + separador + "psp"
                + separador + "informe.txt";

        System.out.println("os.name: " + sistema);
        System.out.println("file.separator: \"" + separador + "\"");
        System.out.println("Ruta construida con las propiedades: " + ruta);

        System.out.println();
        System.out.println("PROPIEDADES QUE EMPIEZAN POR os., user., java.version");
        System.out.println("==============================");

        String[] prefijos;

        if (args.length == 0) {
            prefijos = new String[]{"os.", "user.", "java.version"};
        } else {
            prefijos = args;
        }

        Properties propiedades = System.getProperties();

        TreeMap<String, String> seleccionadas = new TreeMap<>();

        String[] nombres = propiedades.stringPropertyNames().toArray(new String[0]);

        for (int i = 0; i < nombres.length; i++) {
            String nombre = nombres[i];
            for (int j = 0; j < prefijos.length; j++) {
                String prefijo = prefijos[j];
                if (nombre.startsWith(prefijo)) {
                    seleccionadas.put(nombre, propiedades.getProperty(nombre));
                }
            }
        }

        String[] nombresSeleccionados =
                seleccionadas.keySet().toArray(new String[0]);

        for (int i = 0; i < nombresSeleccionados.length; i++) {
            String nombre = nombresSeleccionados[i];
            System.out.println(nombre + " = " + seleccionadas.get(nombre));
        }

        System.out.println();
        System.out.println("PROCESO EN ESPERA");
        System.out.println("==============================");
        System.out.println("Buscame desde otra terminal con: ps -ef | grep InformeSistema");
        System.out.println("Pulsa INTRO para terminar...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("Fin del programa.");
    }
}
