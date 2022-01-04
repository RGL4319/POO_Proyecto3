package modelos;

import java.io.Serializable;

import modelos.usuarios.Usuario;

public class Ticket implements Serializable {

    /**
     * El valor del 'iva' que se usa para la clase
     */
    private final static double iva = 0.16;

    /**
     * La mesa con la que se asoció el Ticket
     */
    private Mesa mesa;

    /**
     * El sub-total a pagar
     */
    private double subtotal;

    /**
     * El total a pagar
     */
    private double total;

    /**
     * Cantidad de propina
     */
    private double propina;

    /**
     * Si se pagó con efectivo o fue un pago con tarjeta
     */
    private boolean esPagoConEfectivo;

    public Ticket( Mesa mesa, double propina, boolean esPagoConEfectivo) {
        this.propina = propina;
        this.mesa = mesa;
        this.subtotal = mesa.getOrden().calcularSubtotal();
        this.total = subtotal * iva;
        this.esPagoConEfectivo = esPagoConEfectivo;
        generarTicket();
    }

    private void generarTicket () {

    }

    public static double getIva() {
        return iva;
    }

    public double getPropina() {
        return propina;
    }

    public Orden getOrden() {
        return mesa.getOrden();
    }

    public Usuario getServidor() {
        return mesa.getOrden().getServidor();
    }

    public double getTotal() {
        return total;
    }

    public boolean isEsPagoConEfectivo() {
        return esPagoConEfectivo;
    }    
}
