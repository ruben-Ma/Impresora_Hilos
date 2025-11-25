package org.cuatrovientos.dam.psp.impresora.Java;

public class Impresora implements Runnable {
    private String nombre;
    private String tipoImpresora;
    private ColaImpresion colaAsignada;

    public Impresora(String nombre, String tipo, ColaImpresion cola) {
        this.nombre = nombre;
        this.tipoImpresora = tipo;
        this.colaAsignada = cola;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Trabajo trabajo = colaAsignada.obtenerTrabajo();

                if (trabajo != null) {
                	System.out.println("Impressora [" + nombre + "] comenzo a imprimir: " + trabajo);
                    
                    int tiempoImpresion = trabajo.getPaginas() * 2 * Oficina.TIME_SCALE; 
                    Thread.sleep(tiempoImpresion);

                    System.out.println("Impresora [" + nombre + "] acado el : " + trabajo + " (Tiempo: " + (tiempoImpresion/Oficina.TIME_SCALE) + "s simulados)");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
