package gui.componentes;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.vistas.OrdenMesa;
import modelos.Platillo;
import modelos.Restaurante;

public class BusquedaPlatillos extends JPanel {

  private Restaurante restaurante;
  private JComboBox<Platillo> busquedaPlatillos;
  private OrdenMesa guiOrden;
  
  public BusquedaPlatillos(Restaurante restaurante, OrdenMesa guiOrden) {
    super();

    this.guiOrden = guiOrden;
    this.restaurante = restaurante;
    crearComponentes();
  }

  private void crearComponentes() {
    JLabel labelBusqueda = new JLabel("Inserta un platillo");
    Box contenedor = Box.createHorizontalBox();
    busquedaPlatillos = new JComboBox<>();

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

    btnAgregar.addActionListener(e -> {
      Platillo pSeleccionado = (Platillo)busquedaPlatillos.getSelectedItem();
      if (busquedaPlatillos.getItemCount() > 0) {
        guiOrden.agregarPlatillo(pSeleccionado);
        busquedaPlatillos.removeItem(pSeleccionado);
      } else {
        JOptionPane.showMessageDialog(null, "Ya no hay más platillos", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    btnFinalizarOrden.addActionListener( e -> {
      int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea finalizar la orden?", "Finalizar orden", JOptionPane.YES_NO_OPTION);
      if ( respuesta == JOptionPane.YES_OPTION ) {
        guiOrden.finalizarOrden();
      }
    } );

    contenedor.add(labelBusqueda);
    contenedor.add(Box.createHorizontalStrut(5));
    contenedor.add(busquedaPlatillos);
    contenedor.add(Box.createHorizontalStrut(5));
    contenedor.add(btnAgregar);
    contenedor.add(Box.createHorizontalStrut(10));
    contenedor.add(btnFinalizarOrden);

    add(contenedor);
  }
}
