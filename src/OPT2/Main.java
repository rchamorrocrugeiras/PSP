package OPT2;

public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking();

        for (int i = 1; i <= 8; i++) {
            Coche coche = new Coche(parking, "Coche " + i);
            Thread hilo = new Thread(coche);
            hilo.start();
        }
    }
}