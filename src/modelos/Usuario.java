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

    public static int getNumUsuarios() {
        return numUsuarios;
    }

    public static void setNumUsuarios(int numUsuarios) {
        Usuario.numUsuarios = numUsuarios;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static Set<Platillo> getPlatillos() {
        return platillos;
    }

    public static void setPlatillos(Set<Platillo> platillos) {
        Usuario.platillos = platillos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    

}
