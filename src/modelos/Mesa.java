package modelos;

/**
 * Clase que contiene la abstracción de una mesa...
 */
public class Mesa {
    
    private int numMesa;
    private boolean ocupada;
    private Orden orden;

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

    public Orden getOrden () {
        return orden;
    }

    public void borrarOrden () {
        orden = null;
    }

    @Override
    public String toString() {
        return String.format( "Número de mesa: %d, %s", numMesa, ocupada ? "ocupada" : "desocupada" );
    }

}
