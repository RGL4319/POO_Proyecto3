import configuraciones.ManejadorUsuarios;
import gui.IniciarSesion;

/**
 * Clase principal del proyecto.
 */
public class Main {

    /**
     * Método principal el cual será el punto de entrada al proyecto.
     * @param args Pa´rametros de la línea de comando.
     */
    public static void main(String[] args) {
        ManejadorUsuarios.reescribirArchivoUsuarios();
        new IniciarSesion();
    }
}