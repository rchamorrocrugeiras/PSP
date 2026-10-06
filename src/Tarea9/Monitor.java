package Tarea9;

public class Monitor implements Runnable {

    private Descarga[] descargas;

    public Monitor(Descarga[] descargas) {
        this.descargas = descargas;
    }

    public void run() {
        boolean quedanDescargas = true;

        while (quedanDescargas) {
            int activas = 0;

            for (Descarga descarga : descargas) {
                if (descarga.isAlive()) {
                    activas++;
                }
            }

            System.out.println("Descargas en curso: " + activas);

            if (activas == 0) {
                quedanDescargas = false;
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}