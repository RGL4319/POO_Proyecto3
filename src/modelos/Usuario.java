package modelos;

import java.io.Serializable;
import java.util.Set;

public class Usuario implements Serializable {

    private static int numUsuarios;
    private int numVentas;
    private int id;
    private String nombre;
    private int edad;
    private char sexo;
    private String telefono;
    private static Set<Platillo> platillos;

    

    public Usuario(int id, String nombre, int edad, char sexo, String telefono, String usuario, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    private String usuario;
    private String contrasenia;
    
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

    public boolean verificarUsuario ( String usuario, String contrasenia ) {
        return this.usuario.equals( usuario) && this.contrasenia.equals( contrasenia );
    }

}
