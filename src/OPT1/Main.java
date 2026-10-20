package OPT1;

public class Main {

    public static void main(String[] args) {

        Buzon buzon = new Buzon();

        Escritor escritor1 = new Escritor(buzon, "Escritor 1");
        Escritor escritor2 = new Escritor(buzon, "Escritor 2");

        Lector lector1 = new Lector(buzon, "Lector 1");
        Lector lector2 = new Lector(buzon, "Lector 2");

        escritor1.start();
        escritor2.start();

        lector1.start();
        lector2.start();
    }
}
