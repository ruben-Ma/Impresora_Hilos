package org.cuatrovientos.dam.psp.impresora.Java;

import java.util.Random;

public class Impresora implements Runnable {
    private String nombre;
    private String tipoImpresora;
    private ColaImpresion colaAsignada;
    private Random random;

    public Impresora(String nombre, String tipo, ColaImpresion cola) {
        this.nombre = nombre;
        this.tipoImpresora = tipo;
        this.colaAsignada = cola;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Trabajo trabajo = colaAsignada.obtenerTrabajo();

                if (trabajo != null) {
                	System.out.println("Impressora [" + nombre + "] comenzo a imprimir: " + trabajo);
                    
                    long tiempoReal = 30000 + random.nextInt(30001);
                    Thread.sleep(tiempoReal);

                    System.out.println("Impresora [" + nombre + "] acado el : " + trabajo + " (Tiempo: " + (tiempoReal/Oficina.TIME_SCALE) + "s simulados)");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
