import java.time.LocalDate;

import javax.swing.SwingUtilities;

import configuraciones.ManejadorUsuarios;
import gui.VentanaApp;
import modelos.Platillo;
import modelos.Restaurante;
import modelos.usuarios.Administrador;
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
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo tipico de México"));
        res.agregarPlatillo(new Platillo("Enchiladas", 120, "Tortillas con salsa"));
        res.agregarPlatillo(new Platillo("Tacos Dorados", 65, "Tortilla con carne, lechuga, crema y queso"));
        res.agregarPlatillo(new Platillo("Tacos Dorados", 65, "Tortilla con carne, lechuga, crema y queso"));
        res.agregarPlatillo(new Platillo("Tacos Dorados", 65, "Tortilla con carne, lechuga, crema y queso"));
        res.agregarPlatillo(new Platillo("Tacos Dorados", 65, "Tortilla con carne, lechuga, crema y queso"));
        res.agregarPlatillo(new Platillo("Caldo de Pollo", 70, "Puede elegir entre pierna, muslo o rabadilla"));


        SwingUtilities.invokeLater(() -> {
            VentanaApp app = VentanaApp.crearInstancia(res);
            app.setVisible(true);
            app.pack();
            app.crearSesion(new Administrador( "Gamaliel Ríos",  LocalDate.parse("2001-11-24"), 'M', "55-1111-3300", "GamaRL", "123" ));
            
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