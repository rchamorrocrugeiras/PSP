package Tarea1;

public class InformeSistema {

    public static void main (String[] args){
        System.out.println("PROCESADORES");
        System.out.println("====================================================");
        System.out.println("    Disponibles para JVM: " );
        System.out.println("    (son hilos lógicos: con SMT no coinciden con los núcleos físicos)\n");

        System.out.println("MEMORIA · ANTES");
        System.out.println("====================================================");
        System.out.println("    Total reservada: " + " MiB");
        System.out.println("    Libre:  " + " MiB");
        System.out.println("    En uso: " + " MiB");
        System.out.println("    Máxima (-Xmx): " + " MiB\n");

        System.out.println("MEMORIA · DESPUÉS DE RESERVAR 64 MIB");
        System.out.println("====================================================");
        System.out.println("    Total reservada: " + " MiB");
        System.out.println("    Libre:  " + " MiB");
        System.out.println("    En uso: " + " MiB");
        System.out.println("    Máxima (-Xmx): " + " MiB");
        System.out.println("    Incremento en uso: " + " MiB");
        System.out.println();
    }
}
