package modelos.usuarios;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import modelos.Mesa;
import modelos.Orden;
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
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean esAdmin() {
        return (this instanceof Administrador);
    }
}
