package RepasoExamen;

public class Tornos extends Thread {
    private int entradas;
    private int nombreTornos;
    private int marcador;
    private static int sumaTornos = 0;

    public Tornos(String nombreTornos) {
        this.nombreTornos = nombreTornos;
        this.entradas = entradasAleatorias();
        this.marcador = 0;
    }

    private int entradasAleatorias() {
        return (int) (Math.random() * 501) + 500;
    }

    public void run() {

    }
}
