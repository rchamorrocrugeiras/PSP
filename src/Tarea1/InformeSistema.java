package Tarea1;

public class InformeSistema {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        int procesadores = runtime.availableProcessors();

        System.out.println("PROCESADORES");
        System.out.println("=======================");
        System.out.println("Disponibles JVM: " + procesadores);

        System.out.println();
        System.out.println("MEMORIA · ANTES");
        System.out.println("=======================");

        long total = runtime.totalMemory();
        long libre = runtime.freeMemory();
        long maximo = runtime.maxMemory();

        long uso = total - libre;
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
    }
}
