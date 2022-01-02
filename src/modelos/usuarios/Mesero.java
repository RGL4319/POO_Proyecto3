package modelos.usuarios;

import java.time.LocalDate;

/**
 * Clase que funge 
 */
public class Mesero extends Usuario {
    
    public Mesero(int id, String nombre, LocalDate fechaNacimiento, char sexo, String telefono, String usuario, String contrasenia) {
        super(nombre, fechaNacimiento, sexo, telefono, usuario, contrasenia);
    }
}
