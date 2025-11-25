package org.cuatrovientos.dam.psp.impresora.Java;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ColaImpresion {
    private String nombreCola;
    private ArrayList<Trabajo> cola; 
    private Semaphore semaforoTrabajosDisponibles;

    public ColaImpresion(String nombre) {
        this.nombreCola = nombre;
        this.cola = new ArrayList<>(); 
        this.semaforoTrabajosDisponibles = new Semaphore(0);
    }

    public void agregarTrabajo(Trabajo trabajo) {
        synchronized (this) {
            cola.add(trabajo); 
            System.out.println(" En " + nombreCola + ": " + trabajo + ". Total en espera: " + cola.size());
            
            mostrarEstadoCola();
        }
        semaforoTrabajosDisponibles.release();
    }

    public Trabajo obtenerTrabajo() throws InterruptedException {
        semaforoTrabajosDisponibles.acquire();
        
        Trabajo trabajo = null;
        
        synchronized (this) {
            
            if (!cola.isEmpty()) {
                trabajo = cola.remove(0);
            }
        }
        return trabajo;
    }
    
    private void mostrarEstadoCola() {
        System.out.print("    [Estado " + nombreCola + "]: { ");
        for(Trabajo t : cola) {
            System.out.print(t.getPaginas() + "p. ");
        }
        System.out.println("}");
    }
}