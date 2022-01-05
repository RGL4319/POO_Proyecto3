package gui.componentes;

import java.util.Map;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grafica extends JPanel {
    
    private String nombre;

    private Map<String, Double> datos;

    public Grafica( String nombre, Map<String, Double> datos ) {
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
        for (String key : datos.keySet()) {
            texto = new JLabel( key + "         " + String.valueOf(datos.get(key)) );
            contenedor.add( texto );
        }
        add(contenedor);
    }

    public void setDatos(Map<String, Double> datos) {
        this.datos = datos;
        crearComponentes();
    }

}
