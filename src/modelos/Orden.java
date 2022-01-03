package modelos;

import java.util.LinkedHashMap;
import java.util.Map;

import modelos.usuarios.Usuario;

public class Orden {
    
    private static int numOrdenes = 0;

    private int id;
    private Usuario servidor;
    private Map<Platillo, Integer> platillos;

    public Orden ( Usuario servidor ) {
        this.id = ++numOrdenes;

        this.servidor = servidor;
        platillos = new LinkedHashMap<>();
    }

    public void agregarPlatillo ( Platillo platillo ) {
        Integer n = platillos.get( platillo );
        platillos.put( platillo, n == null ? 1 : n + 1 );
    }

    public Map<Platillo, Integer> getPlatillos () {
        return platillos;
    }

    public Usuario getServidor () {
        return servidor;
    }

    public double calcularSubtotal () {
        double total = 0;
        for (Platillo platillo : platillos.keySet())
            total += platillo.getPrecio() * platillos.get(platillo);
        return total;
    }

    /**
     * Método de acceso de consulta para el atributo 'id' de la orden
     * @return el 'id' de la orden
     */
    public int getId() {
      return id;
    }
}
