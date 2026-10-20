package OPT1;

public class Buzon {

    private String mensaje;
    private boolean lleno = false;

    public synchronized void escribir(String mensaje, String escritor) throws InterruptedException {
        while (lleno) {
            System.out.println(escritor + " el buzón está lleno");
            wait();
        }

        this.mensaje = mensaje;
        lleno = true;

        System.out.println(Thread.currentThread().getName() + " escribe: " + mensaje);
        notifyAll();
    }

    public synchronized String leer(String lector) throws InterruptedException {
        while (!lleno) {
            System.out.println(Thread.currentThread().getName() + " espera para leer.");
            wait();
        }

        String mensajeLeido = mensaje;
        lleno = false;

        System.out.println(Thread.currentThread().getName() + " lee: " + mensajeLeido);

        notifyAll();
        return mensajeLeido;
    }
}
