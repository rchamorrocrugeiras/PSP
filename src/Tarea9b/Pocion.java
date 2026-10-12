package Tarea9b;

import java.util.Random;

public class Pocion implements Runnable {

    private String nombre;
    private int fases;
    private int duracionFase;
    private long tiempoTotal;

    public Pocion(String nombre) {
        this.nombre = nombre;

        Random random = new Random();
        this.fases = random.nextInt(5) + 4; //Genera un número aleatorio entre 4 y 8, ambos incluidos
        this.duracionFase = random.nextInt(201) + 200; //Genera un número aleatorio entre 200 y 400, ambos incluidos
        this.tiempoTotal = 0; //Inicializa el tiempo total a cero
    }

    public void run() {
        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= fases; i++) {
            try {
                Thread.sleep(duracionFase);
                System.out.println("[" + nombre + "] fase " + i + "/" + fases); //Muestra el nombre de la poción, la fase actual y el total de fases.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //Interrumpe el hilo actual
                return;
            }
        }

        tiempoTotal = System.currentTimeMillis() - inicio; //Se calcula el tiempo total transcurrido

        System.out.println("[" + nombre + "] lista en " + tiempoTotal + " ms"); //Muestra el nombre de la poción y el tiempo total que ha tardado.
    }

    public String getNombre() {
        return nombre;
    }

    public long getTiempoTotal() {
        return tiempoTotal;
    }
}
