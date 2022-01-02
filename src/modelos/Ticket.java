package modelos;

import modelos.usuarios.Usuario;

public class Ticket {
    
    private final static double iva = 0.16;
    private Mesa mesa;
    private double subtotal;
    private double total;
    private double propina;
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
