import javax.swing.SwingUtilities;

import configuraciones.ManejadorUsuarios;
import gui.Login;

/**
 * Clase principal del proyecto.
 */
public class Main {

    /**
     * Método principal el cual será el punto de entrada al proyecto.
     * @param args Parámetros de la línea de comando.
     */
    public static void main(String[] args) {
        ManejadorUsuarios.reescribirArchivoUsuarios();

        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.pack();
            login.setVisible(true);
        });
    }
}