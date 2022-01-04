package gui.componentes;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelos.Platillo;
import modelos.Restaurante;

public class BusquedaPlatillos extends JPanel {

  private Restaurante restaurante;
  private JComboBox<Platillo> busquedaPlatillos;
  private OrdenMesa guiOrden;
  private JLabel descripcion;
  
  public BusquedaPlatillos(Restaurante restaurante, OrdenMesa guiOrden) {
    super();

    this.guiOrden = guiOrden;
    this.restaurante = restaurante;

    crearComponentes();
  }

  private void crearComponentes() {
    JLabel labelBusqueda = new JLabel("Inserta un platillo");

    Box panelBusqueda = Box.createHorizontalBox();
    busquedaPlatillos = new JComboBox<>();

    descripcion = new JLabel("");

    for (Platillo p : restaurante.getPlatillos()) {
      busquedaPlatillos.addItem(p);
    }

    busquedaPlatillos.setEditable(true);
    busquedaPlatillos.setSelectedItem(null);

    JButton btnAgregar = new JButton("Agregar");
    JButton btnFinalizarOrden = new JButton("Finalizar orden");

    btnAgregar.setBackground( new Color( 9, 150, 47 ) );
    btnFinalizarOrden.setBackground( new Color( 196, 153, 10 ) );
    
    btnAgregar.setForeground( Color.WHITE );
    btnFinalizarOrden.setForeground( Color.WHITE );

    // TODO: Detectar cambio de platillo seleccionado
    busquedaPlatillos.addPropertyChangeListener(e -> {
      System.out.print("Nadda");
    });

    btnAgregar.addActionListener(e -> {
      Platillo pSeleccionado = (Platillo) busquedaPlatillos.getSelectedItem();

      if (pSeleccionado != null) {
        guiOrden.agregarPlatillo(pSeleccionado);
        busquedaPlatillos.removeItem(pSeleccionado);
      } else {
        JOptionPane.showMessageDialog(null, "No has seleccionado algún platillo", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    btnFinalizarOrden.addActionListener( e -> {
      int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea finalizar la orden?", "Finalizar orden", JOptionPane.YES_NO_OPTION);
      if ( respuesta == JOptionPane.YES_OPTION ) {
        guiOrden.finalizarOrden();
      }
    } );

    panelBusqueda.add(labelBusqueda);
    panelBusqueda.add(Box.createHorizontalStrut(5));
    panelBusqueda.add(busquedaPlatillos);
    panelBusqueda.add(Box.createHorizontalStrut(5));
    panelBusqueda.add(btnAgregar);
    panelBusqueda.add(Box.createHorizontalStrut(10));
    panelBusqueda.add(btnFinalizarOrden);

    add(panelBusqueda);
  }
}
