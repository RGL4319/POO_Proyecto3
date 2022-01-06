package gui.componentes;

import java.util.Map;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.usuarios.Usuario;

public class Grafica extends JPanel {
    
    private String nombre;

    private Map<Usuario, Double> datos;

    public Grafica( String nombre, Map<Usuario, Double> datos ) {
        super();
        this.nombre = nombre;
        this.datos = datos;
        crearComponentes();
    }

    private void crearComponentes() {
        removeAll();
        Box contenedor = Box.createVerticalBox();
        JLabel texto;
        texto = new JLabel( nombre );
        contenedor.add( texto );
        contenedor.add( Box.createVerticalStrut(20) );
        for (Usuario key : datos.keySet()) {
            texto = new JLabel( key.getNombre() + "         " + String.valueOf(datos.get(key)) );
            contenedor.add( texto );
        }
        add(contenedor);
    }

    public void setDatos(Map<Usuario, Double> datos) {
        this.datos = datos;
        crearComponentes();
    }

}
