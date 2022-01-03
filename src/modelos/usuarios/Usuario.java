package modelos.usuarios;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import modelos.Mesa;
import modelos.Orden;
import modelos.Platillo;
import modelos.Ticket;

public class Usuario implements Serializable {

    private static int numUsuarios;

    private int numVentas;
    private int id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private char sexo;
    private String telefono;
    private String usuario;
    private String password;

    private static Set<Platillo> platillos;

    public Usuario(String nombre, LocalDate fechaNacimiento, char sexo, String telefono, String usuario, String password) {
        this.id = ++numUsuarios;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
    }

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

    public boolean verificarCredenciales ( String usuario, String contrasenia ) {
        return this.usuario.equals( usuario) && this.password.equals( contrasenia );
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
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public char getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
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

    public String getPassword() {
        return password;
    }

    public boolean esAdmin() {
        return (this instanceof Administrador);
    }
}
