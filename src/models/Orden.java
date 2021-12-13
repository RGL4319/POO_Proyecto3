package models;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 */
public class Orden {
    
    private Map<Platillo, Integer> platillos;

    public Orden () {
        platillos = new LinkedHashMap<>();
        // Platillo p = new Platillo(1, "Pizza", 123.2, "desdcrrvfdssd");
        // agregarPlatillo(p);
        // agregarPlatillo(p);
        // System.out.println(platillos.toString());
    }

    public void agregarPlatillo ( Platillo platillo ) {
        Integer n = platillos.get( platillo );
        platillos.put( platillo, n == null ? 1 : n + 1 );
    }

}
