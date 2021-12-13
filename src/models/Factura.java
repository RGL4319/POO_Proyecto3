package models;

/**
 * Clase que contiene la abstracción de una factura creada...
 */
public class Factura {
    
    private static double iva;
    private double propina;
    private double precio;
    private String concepto;
    private double cantidad;
    private double total;
    private boolean esPagoConEfectivo;

    public Factura(double propina, double precio, String concepto, double cantidad, double total,
            boolean esPagoConEfectivo) {
        this.propina = propina;
        this.precio = precio;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.total = total;
        this.esPagoConEfectivo = esPagoConEfectivo;
    }
    
    @Override
    public String toString() {
        return "";
        // return String.format("Propina: %f, Precio: %f, Concepto: %s, Cantidad: %f, Total: %f, Pago con: %s", "" );
    }

}
