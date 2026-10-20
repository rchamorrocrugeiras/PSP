package OPT2;

public class Parking {

    private int plazasLibres = 3;

    public synchronized void entrar(String coche) throws InterruptedException {
        while (plazasLibres == 0) {
            System.out.println(coche + " espera: parking lleno.");
            wait();
        }

        plazasLibres--;

        System.out.println(coche + " entra. Plazas libres: " + plazasLibres);
    }

    public synchronized void salir(String coche) {

        plazasLibres++;

        System.out.println(coche + " sale. Plazas libres: " + plazasLibres);

        notifyAll();
    }
}
