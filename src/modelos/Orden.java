package modelos;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 */
public class Orden {
    
    private Usuario servidor;
    private Map<Platillo, Integer> platillos;

    public Orden ( Usuario servidor ) {
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

}
