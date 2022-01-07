package modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

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
/**
 * La fecha y hora de acuerdo al momento de que se generó el ticket
 */
    private LocalDateTime fechaHora;
/**
 * Constructor de la clase 
 * @param mesa que contiene una orden 
 * @param propina monto dado por el usuario 
 * @param esPagoConEfectivo forma de pago 
 */
    public Ticket( Mesa mesa, double propina, boolean esPagoConEfectivo) {
        this.propina = propina;
        this.mesa = mesa.getNumeroMesa();
        this.orden = mesa.getOrden();
        this.subtotal = orden.calcularSubtotal();
        this.total = Math.ceil(subtotal * iva + propina);
        this.esPagoConEfectivo = esPagoConEfectivo;
        fechaHora = LocalDateTime.now();
        generarTicket();
    }
/**
 * Se encarga de generar el ticket de acuerdo a las características de las ordenes 
 */
    private void generarTicket () {
        try {
           // private static final String ruta1 = new File("archivos/").getAbsolutePath();
          //TODO: Incluir fecha y hora en el nombre del archivo
          BufferedWriter escritor = new BufferedWriter( new FileWriter( new File("tickets/" /*+ fechaHora.toString()*/ + "(" + orden.getId() + ").txt" ) ) );
          escritor.append(String.valueOf(fechaHora.toString() + "\n"));
          escritor.append(String.valueOf("Orden: "+ orden.getId()) + "\n");
          escritor.append(String.valueOf("Servidor: "+ orden.getServidor().getNombre()) + "\n");
          escritor.append(String.valueOf("Mesa: " + mesa) + "\n");
          escritor.append(String.valueOf("Platillo: "+ orden.getPlatillos()) + "\n");
          escritor.append(String.valueOf("Subtotal: "+ subtotal) + "\n");
          escritor.append(String.valueOf("Total:" +total) + "\n");
          escritor.append(String.valueOf("Pago " + (esPagoConEfectivo ? "en efectivo" : "con tarjeta") + "." ) + "\n");
          escritor.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal con la generación del ticket.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
/**
 * Se encarga de leer el IVA definido 
 * @return iva monto 
 */
    public static double getIva() {
        return iva;
    }
/**
 * Se encarga de leer la propina ingresada por el usuario 
 * @return propina monto 
 */
    public double getPropina() {
        return propina;
    }
/**
 * Se encarga de leer la orden asociada a una mesa 
 * @return orden 
 */
    public Orden getOrden() {
        return orden;
    }
/***
 * Se encarga de leer el pago total de la orden creada 
 * @return total monto a pagar 
 */
    public double getTotal() {
        return total;
    }
/**
 * Se encarga de obtener el tipo de pago 
 * @return esPagoConEfectivo true o false según sea el caso 
 */
    public boolean isEsPagoConEfectivo() {
        return esPagoConEfectivo;
    }    
}
