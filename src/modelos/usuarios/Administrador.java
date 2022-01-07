package modelos.usuarios;

import java.time.LocalDate;

/**
 * Clase que funge como administrador del sisttema el cual puede realizar ciertas acciones diferentes 
 * a la de un mesero 
 */
public class Administrador extends Usuario {
/**
 * Constructor de la clase 
 * @param nombre del servidor 
 * @param fechaNacimiento del servidor 
 * @param sexo del servidor 
 * @param telefono del servidor 
 * @param usuario del servidor 
 * @param contrasenia del servidor 
 */
    public Administrador(String nombre, LocalDate fechaNacimiento, char sexo, String telefono, String usuario, String contrasenia) {
        super(nombre, fechaNacimiento, sexo, telefono, usuario, contrasenia);
    }
/**
 * Permite obtener las ventas de cada uno de los servidores que se encuentran registrados en el restaurante 
 * @param deMesa
 */
    public void consultarVentas( boolean deMesa ) {

    }
/**
 * Permite modificar al mesero seleccionado 
 * @param mesero a modificar 
 */
    public void modificarMesero ( Mesero mesero ) {
        
    }
/**
 * Permite registrar a un nuevo mesero
 */
    public Mesero registrarMesero() {
        return null;    
    }
/**
 * Permite tener acceso a la consultar de estadísticas 
 * @param dePlatillo
 */
    public void consultarEstadisticas ( boolean dePlatillo ) {

    }

}
