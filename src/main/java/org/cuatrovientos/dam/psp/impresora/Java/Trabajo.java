package org.cuatrovientos.dam.psp.impresora.Java;

import java.util.Random;

public class Trabajo {
    private static int contadorIds = 1;
    private int id;
    private int paginas;
    private String tipo; 
    private String propietario;

    public Trabajo(String propietario, String tipo) {
        this.id = contadorIds++;
        this.propietario = propietario;
        this.tipo = tipo;
        this.paginas = new Random().nextInt(20) + 1;
    }

    public int getPaginas() { return paginas; }
    public String getTipo() { return tipo; }
    
    @Override
    public String toString() {
        return "[Trabajo" + id + " | " + tipo + " | " + paginas + " pgs | De: " + propietario + "]";
    }
}