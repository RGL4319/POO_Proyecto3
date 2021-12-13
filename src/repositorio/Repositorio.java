package repositorio;

import java.util.LinkedList;
import java.util.List;

import modelos.*;

public class Repositorio {
    
    private Repositorio instancia;
    private final String ruta = ".\\archivos\\";
    private static final String ARCHIVO_PLATILLOS = "platillos.rest";
    private static final String ARCHIVO_USUARIOS = "usuarios.rest";
    private static final String ARCHIVO_ORDENES = "ordens.rest";
    private static final String ARCHIVO_FACTURAS = "facturas.rest";

    private Repositorio () {}

    public Repositorio getInstancia () {
        if ( instancia == null )
            instancia = new Repositorio();
        return  instancia;
    }

    public List<Platillo> getPlatillos () {
        return null;
    }

    public List<Usuario> getUsuarios () {
        return null;
    }

    public List<Mesa> getMesas ( int numMesas ) {
        List<Mesa> mesas = new LinkedList<>();
        for (int i = 1; i <= numMesas; i++)
            mesas.add( new Mesa(i) );
        return mesas;
    }

    public List<Ticket> getTickets () {
        return null;
    }

    public List<Factura> getFacturas () {
        return null;
    }

}
