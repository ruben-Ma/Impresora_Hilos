package org.cuatrovientos.dam.psp.impresora.Java;

public class Oficina {

    public static final int TIME_SCALE = 100; 

    public static void main(String[] args) {
        System.out.println("Oficina de impresion iniciada...");

        ColaImpresion colaColor = new ColaImpresion("COLA COLOR");
        ColaImpresion colaBN = new ColaImpresion("COLA B/N");

        Thread ord1 = new Thread(new Ordenador("Ordenador-1", colaColor, colaBN));
        Thread ord2 = new Thread(new Ordenador("Ordenador-2", colaColor, colaBN));
        Thread ord3 = new Thread(new Ordenador("Ordenador-3", colaColor, colaBN));

        Thread impColor1 = new Thread(new Impresora("HP-Color-01", "COLOR", colaColor));
        Thread impColor2 = new Thread(new Impresora("HP-Color-02", "COLOR", colaColor));
        Thread impBN1 = new Thread(new Impresora("Epson-Negro-01", "B/N", colaBN));

        impColor1.start();
        impColor2.start();
        impBN1.start();
        
        ord1.start();
        ord2.start();
        ord3.start();
    }
}
