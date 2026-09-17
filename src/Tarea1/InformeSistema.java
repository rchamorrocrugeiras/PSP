package Tarea1;

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

        System.out.println("Incremento en uso: " + incrementoMiB + " MiB");
    }
}
