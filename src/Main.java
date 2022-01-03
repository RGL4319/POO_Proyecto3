import javax.swing.SwingUtilities;

import configuraciones.ManejadorUsuarios;
import gui.VentanaApp;
import modelos.Restaurante;

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

        Restaurante res = new Restaurante("COCINA MEXICANA", 8);

        SwingUtilities.invokeLater(() -> {
            VentanaApp app = VentanaApp.crearInstancia(res);
            app.setVisible(true);
            //app.pack();
            // Login login = new Login(res);
            // login.pack();
            // login.setVisible(true);

            // Inicio inicio = new Inicio(res, new Usuario( "Gamaliel Ríos",  LocalDate.parse("2001-11-24"), 'M', "55-1111-3300", "GamaRL", "123" ) );
            // inicio.pack();
            // inicio.setVisible(true);
        });
    }
}