package modelos;

import java.util.LinkedList;
import java.util.List;

public class AnalizadorEst {
    
    private static List<Orden> ordenes = new LinkedList<>();

    public void agregarOrdenFinalizada ( Orden orden ) {
        ordenes.add( orden );
    }

}
