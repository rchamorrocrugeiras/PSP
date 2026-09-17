package Tarea1;

public class InformeSistema {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        int procesadores = runtime.availableProcessors();

        System.out.println("PROCESADORES");
        System.out.println("=======================");
        System.out.println("Disponibles JVM: " + procesadores);
    }
}
