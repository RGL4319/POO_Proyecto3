package modelos.usuarios;

import java.time.LocalDate;

/**
 * Clase que funge 
 */
public class Mesero extends Usuario {
    
    public Mesero(String nombre, LocalDate fechaNacimiento, char sexo, String telefono, String usuario, String password) {
        super(nombre, fechaNacimiento, sexo, telefono, usuario, password);
    }
}
