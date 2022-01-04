package modelos;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import modelos.usuarios.Usuario;

public class Orden implements Serializable {
    
    private UUID id;
    private Usuario servidor;
    private Map<Platillo, Integer> platillos;

    public Orden ( Usuario servidor ) {
        this.id = UUID.randomUUID();

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
     public void setNumDePlatillo(Platillo platillo, int valor) {
         platillos.put(platillo, valor);
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
    public UUID getId() {
      return id;
    }
}
