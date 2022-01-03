import java.time.LocalDate;

import javax.swing.SwingUtilities;

import configuraciones.ManejadorUsuarios;
import gui.FormularioMesero;
import gui.Inicio;
import gui.Login;
import gui.VentanaUsuarios;
import modelos.Restaurante;
import modelos.usuarios.Usuario;

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
            Login login = new Login(res);
            login.pack();
            login.setVisible(true);

            // Inicio inicio = new Inicio(res, new Usuario( "Gamaliel Ríos",  LocalDate.parse("2001-11-24"), 'M', "55-1111-3300", "GamaRL", "123" ) );
            // inicio.pack();
            // inicio.setVisible(true);
            
            // FormularioMesero form = new FormularioMesero(res, new Usuario( "Gamaliel Ríos",  LocalDate.parse("2001-11-24"), 'H', "55-1111-3300", "GamaRL", "123" ));
            // // FormularioMesero form = new FormularioMesero(res, null);
            // form.pack();
            // form.setVisible(true);

            // System.out.println("Inicio");
            // VentanaUsuarios v = new VentanaUsuarios(res, new Usuario( "Gamaliel Ríos",  LocalDate.parse("2001-11-24"), 'M', "55-1111-3300", "GamaRL", "123" ) );
            // v.pack();
            // v.setVisible(true);
        });
    }
}