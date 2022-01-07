package modelos;

import java.io.Serializable;

/**
 * Clase que contiene la abstracción de una mesa
 * Implementa a la interface Serializable 
 * 
 */
public class Mesa implements Serializable {
/**
 * Número de mesa 
 */
    private int numMesa;
/**
 * Estado de la mesa (ocupada/desocupada)
 */
    private boolean ocupada;
    /**
     * Orden asociada a la mesa 
     */
    private Orden orden;
/**
 * Constructor de la clase 
 * @param numMesa el número de mesa asociado dentro del restaurante 
 */
    public Mesa(int numMesa) {
        this.numMesa = numMesa;
    }
/**
 * Se encarga de modificar el estado de las mesas a ocupadas 
 */
    public void ocupar() {
        ocupada = true;
    }
/**
 * Se encarga de modificar el estado de las mesas a desocupadas
 */
    public void desocupar() {
        ocupada = false;
    }
/**
 * Se encarga de indicar si la mesa está ocupada 
 * @return ocupada estado de la mesa 
 */
    public boolean estaOcupada() {
        return ocupada;
    }
/**
 * Se encarga de indicar el número que tiene la mesa 
 * @return numMesa número de la mesa a consultar 
 */
    public int getNumeroMesa() {
        return numMesa;
    }
/**
 * Se encarga de leer la orden que contiene la mesa 
 * @return orden establecida en la mesa 
 */
    public Orden getOrden() {
        return orden;
    }
/**
 * Se encarga de modificar la orden de las mesas 
 * @param orden
 */
    public void setOrden(Orden orden) {
        this.orden = orden;
    }
/**
 * Borra las ordenes de las mesas 
 */
    public void borrarOrden() {
        orden = null;
    }
/**
 * Sobreescritura del métdo toString, propiedades de la mesa (ocupada/desocupada)
 */
    @Override
    public String toString() {
        return String.format("Mesa: %d (%s)", numMesa, ocupada ? "ocupada" : "desocupada");
    }

}
