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

        for (Descarga descarga : descargas) {
            descarga.start();
        }

        long acumuladoSerie = 0;

        for (Descarga descarga : descargas) {
            try {
                descarga.join();
            } catch (InterruptedException e) {
                return;
            }

            acumuladoSerie += descarga.getTiempoDescarga();
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