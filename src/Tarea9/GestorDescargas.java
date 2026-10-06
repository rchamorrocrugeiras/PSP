package Tarea9;

public class GestorDescargas {

    public static void main(String[] args) {
        String[] archivos = {
                "cuarzos.png",
                "meditacion.mp4",
                "mantras.mp3",
                "horoscopo.pdf"
        };

        Descarga[] descargas = new Descarga[archivos.length];

        for (int i = 0; i < archivos.length; i++) {
            descargas[i] = new Descarga(archivos[i]);
            descargas[i].setName("Descarga-" + archivos[i]);
        }

        long inicio = System.currentTimeMillis();

        Thread monitor = new Thread(new Monitor(descargas));
        Thread instalador = new Thread(
                new Instalador(descargas[1], descargas[2]));

        for (Descarga descarga : descargas) {
            descarga.start();
        }

        monitor.start();
        instalador.start();

        long acumuladoSerie = 0;

        try {
            descargas[1].join(3000);

            if (descargas[1].isAlive()) {
                System.out.println(
                        "Aviso: meditacion.mp4 sigue descargándose después de 3 segundos.");
            }

            for (Descarga descarga : descargas) {
                descarga.join();
                acumuladoSerie += descarga.getTiempoDescarga();
            }

            monitor.join();
            instalador.join();

        } catch (InterruptedException e) {
            return;
        }

        long tiempoReal = System.currentTimeMillis() - inicio;

        System.out.println();
        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real: " + tiempoReal + " ms");
        System.out.println(
                "Si se hubieran descargado una detrás de otra: "
                        + acumuladoSerie + " ms");
    }
}