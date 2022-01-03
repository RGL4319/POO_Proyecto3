package modelos;

import java.io.Serializable;

public class Platillo implements Serializable{

    /**
     * Cantidad de platillos generados
     */
    private static int utlimoPlatillo;
    
    /**
     * Id del platillo
     */
    private int id;

    /**
     * Nombre del platillo
     */
    private String nombre;

    /**
     * Precio del platillo
     */
    private double precio;

    /**
     * Descripción del platillo
     */
    private String descripcion;
    
    /**
     * Constructor de la clase
     *
     * @param nombre el nombre del platillo
     * @param precio el precio del platillo
     * @param descripcion breve descripción del platillo
     */
    public Platillo(String nombre, double precio, String descripcion) {
        this.id = ++utlimoPlatillo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    /**
     * Método de acceso de consulta para el atributo 'id'
     * @return el id del platillo
     */
    public int getId() {
        return id;
    }

    /**
     * Método de acceso de consulta para el atrbuto 'nombre'
     * @return el nombre del platillo
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método de acceso de consulta para el atributo 'precio'
     * @return el precio del platillo
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método de acceso de modificación para el atributo 'precio'
     * @param precio el precio del platillo
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Método de acceso de consulta para el atributo 'descripción'
     * @return la descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
