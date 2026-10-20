package OPT1;

public class Escritor extends Thread {

    private Buzon buzon;

    public Escritor(Buzon buzon, String nombre) {
        super(nombre);
        this.buzon = buzon;
    }

    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                buzon.escribir("Mensaje " + i, getName());
            }
        } catch (InterruptedException e) {
            System.out.println("El escritor ha sido interrumpido.");
        }
    }
}
