package Tarea3;

import java.io.File;

public class Tarea3 {

    public static void main(String[] args) throws Exception {
        String sistema = System.getProperty("os.name");

        String comando;

        if (sistema.contains("Windows")) {
            comando = "cmd /c dir";
        } else {
            comando = "ls";
        }

        System.out.println("DIRECTORIO POR DEFECTO");
        System.out.println("Directorio: " + new File(".").getAbsolutePath());
        System.out.println("user.dir: " + System.getProperty("user.dir"));

        Runtime.getRuntime().exec(comando);

        System.setProperty("user.dir", System.getProperty("user.home"));

        System.out.println("\nDIRECTORIO HOME");
        System.out.println("Directorio: " + new File(".").getAbsolutePath());
        System.out.println("user.dir: " + System.getProperty("user.dir"));

        Runtime.getRuntime().exec(comando);

        System.setProperty("user.dir", System.getProperty("java.io.tmpdir"));

        System.out.println("\nDIRECTORIO TEMPORAL");
        System.out.println("Directorio: " + new File(".").getAbsolutePath());
        System.out.println("user.dir: " + System.getProperty("user.dir"));

        Runtime.getRuntime().exec(comando);
    }
}