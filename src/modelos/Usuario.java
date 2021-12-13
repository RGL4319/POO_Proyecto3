package modelos;

import java.util.Set;

public class Usuario {

    private static int numUsuarios;
    private int numVentas;
    private int id;
    private String nombre;
    private int edad;
    private char sexo;
    private String telefono;
    private static Set<Platillo> platillos;
    
    public Orden crearOrden() {
        return null;
    }

    public void consultarMesas () {

    }

    public Ticket finalizarOrden ( Mesa mesa, double propina, boolean esPagoConEfectivo ) {
        numVentas++;
        Ticket ticket = new Ticket( mesa, propina, esPagoConEfectivo );
        mesa.borrarOrden();
        return ticket;
    }

    

    public Factura facturar ( Orden orden ) {
        return null;
    }

}
