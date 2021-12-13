package models;

/**
 * Clase que contiene la abstracción de una mesa...
 */
public class Mesa {
    
    private int numMesa;
    private boolean ocupada;

    public Mesa ( int numMesa ) {
        this.numMesa = numMesa;
    }

    public void ocupar() {
        ocupada = true;
    }

    public void desocupar() {
        ocupada = false;
    }

    public boolean estaOcupada () {
        return ocupada;
    }

    public int getNumeroMesa () {
        return numMesa;
    }

    @Override
    public String toString() {
        return String.format( "Número de mesa: %d, %s", numMesa, ocupada ? "ocupada" : "desocupada" );
    }

}
