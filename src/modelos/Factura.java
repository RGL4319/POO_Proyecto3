package modelos;

/**
 * Clase que contiene la abstracción de una factura creada...
 */
public class Factura {
    
    private Ticket ticket;
    private String concepto;
    private String rfc;

    public Factura( Ticket ticket, String rfc, String concepto ) {
        this.ticket = ticket;
        this.rfc = rfc;
        this.concepto = concepto;
    }

}
