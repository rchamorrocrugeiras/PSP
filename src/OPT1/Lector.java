package OPT1;

public class Lector extends Thread {

    private Buzon buzon;

    public Lector(Buzon buzon, String nombre) {
        super(nombre);
        this.buzon = buzon;
    }

    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                buzon.leer(getName());
            }
        } catch (InterruptedException e) {
            System.out.println("El lector ha sido interrumpido.");
        }
    }
}