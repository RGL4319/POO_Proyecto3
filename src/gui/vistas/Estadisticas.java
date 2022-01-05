package gui.vistas;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Restaurante;

public class Estadisticas extends JPanel {
    
    private Restaurante restaurante;

    public Estadisticas( Restaurante restaurante ) {
        super();
        this.restaurante = restaurante;
        crearComponentes();
    }

    private void crearComponentes() {
        Box contenedor = Box.createVerticalBox();
        Box platillos = Box.createVerticalBox();

        // Calcular el mejor vendedor del mes
        String mejorVendedor = "Juantio";
        contenedor.add( new JLabel( String.format("El mejor vendedor del mes es %s.", mejorVendedor) ) );
        contenedor.add( Box.createVerticalStrut(20) );
        contenedor.add( new JLabel( "PLATILLOS" ) );
        contenedor.add( Box.createVerticalStrut(20) );

        platillos.add( new JLabel("Aquí van los platillos y sus porcentajes") );

        contenedor.add( platillos );
        add( contenedor );
    }

}
