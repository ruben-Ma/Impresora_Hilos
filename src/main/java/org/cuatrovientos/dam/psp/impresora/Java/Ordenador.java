package org.cuatrovientos.dam.psp.impresora.Java;

import java.util.Random;

public class Ordenador implements Runnable {
    private String nombre;
    private ColaImpresion colaColor;
    private ColaImpresion colaBN;
    private Random random;

    public Ordenador(String nombre, ColaImpresion colaColor, ColaImpresion colaBN) {
        this.nombre = nombre;
        this.colaColor = colaColor;
        this.colaBN = colaBN;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
		    

		    boolean esColor = random.nextBoolean();
		    String tipo = esColor ? "COLOR" : "B/N";
		    ColaImpresion colaDestino = esColor ? colaColor : colaBN;

		    Trabajo nuevoTrabajo = new Trabajo(this.nombre, tipo);

		    colaDestino.agregarTrabajo(nuevoTrabajo);
		}
    }
}
