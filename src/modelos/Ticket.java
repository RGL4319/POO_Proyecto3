package modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.time.LocalDateTime;

import modelos.usuarios.Usuario;

public class Ticket implements Serializable {

    /**
     * El valor del 'iva' que se usa para la clase
     */
    private final static double iva = 1.16;

    /**
     * La mesa con la que se asoció el Ticket
     */
    private int mesa;

    /**
     * La orden del ticket
     */
    private Orden orden;

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

    private LocalDateTime fechaHora;

    public Ticket( Mesa mesa, double propina, boolean esPagoConEfectivo) {
        this.propina = propina;
        this.mesa = mesa.getNumeroMesa();
        this.orden = mesa.getOrden();
        this.subtotal = orden.calcularSubtotal();
        this.total = subtotal * iva + propina;
        this.esPagoConEfectivo = esPagoConEfectivo;
        fechaHora = LocalDateTime.now();
        generarTicket();
    }

    private void generarTicket () {
        // BufferedWriter escritor = new BufferedWriter( new FileWriter( new File() ) );
        System.out.println(orden.getServidor());
        System.out.println("Mesa " + mesa);
        System.out.println(orden.getPlatillos());
        System.out.println(subtotal);
        System.out.println(total);
        System.out.println("Pago " + (esPagoConEfectivo ? "en efectivo" : "con tarjeta") + "." );
    }

    public static double getIva() {
        return iva;
    }

    public double getPropina() {
        return propina;
    }

    public Orden getOrden() {
        return orden;
    }

    public double getTotal() {
        return total;
    }

    public boolean isEsPagoConEfectivo() {
        return esPagoConEfectivo;
    }    
}
