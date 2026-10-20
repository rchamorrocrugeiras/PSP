package OPT2;

public class Coche extends Thread {

    private Parking parking;

    public Coche(Parking parking, String nombre) {
        super(nombre);
        this.parking = parking;
    }

    public void run() {
        try {
            parking.entrar(getName());

            int tiempo = (int) (Math.random() * 5000) + 1000;

            Thread.sleep(tiempo);

            parking.salir(getName());

        } catch (InterruptedException e) {
            System.out.println(getName() + " ha sido interrumpido.");
        }
    }
}