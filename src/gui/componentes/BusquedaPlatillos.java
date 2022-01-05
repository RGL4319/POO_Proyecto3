package gui.componentes;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import gui.VentanaApp;
import modelos.Platillo;
import modelos.Restaurante;

class PlatillosComboBoxRenderer extends BasicComboBoxRenderer {

  /**
   * El restaurante asociado con el programa
   */
  private Restaurante restaurante;

  public PlatillosComboBoxRenderer(Restaurante restaurante) {
    super();

    this.restaurante = restaurante;
  }

  @Override
  public Component getListCellRendererComponent(JList<?> list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {

    if (isSelected) {
      setBackground(list.getSelectionBackground());
      setForeground(list.getSelectionForeground());

      if (index >= 0) {
        List<Platillo> platillos = new ArrayList<>(restaurante.getPlatillos());
        list.setToolTipText(platillos.get(index).getDescripcion());
      }
    } else {
      setBackground(list.getBackground());
      setForeground(list.getForeground());
    }

    setFont(list.getFont());
    setText((value == null) ? "" : value.toString());
    return this;
  }
}

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

    //busquedaPlatillos.setEditable(true);
    //busquedaPlatillos.setSelectedItem(null);

    JButton btnAgregar = new JButton("Agregar");
    JButton btnFinalizarOrden = new JButton("Finalizar orden");

    btnAgregar.setBackground(new Color(9, 150, 47));
    btnFinalizarOrden.setBackground(new Color(196, 153, 10));

    btnAgregar.setForeground(Color.WHITE);
    btnFinalizarOrden.setForeground(Color.WHITE);

    busquedaPlatillos.setRenderer(new PlatillosComboBoxRenderer(restaurante));

    btnAgregar.addActionListener(e -> {
      Platillo pSeleccionado = (Platillo) busquedaPlatillos.getSelectedItem();

      if (pSeleccionado != null) {
        guiOrden.agregarPlatillo(pSeleccionado);
        //busquedaPlatillos.removeItem(pSeleccionado);
      } else {
        JOptionPane.showMessageDialog(null, "No has seleccionado algún platillo", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    btnFinalizarOrden.addActionListener(e -> {
      int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea finalizar la orden?", "Finalizar orden",
          JOptionPane.YES_NO_OPTION);
      if (respuesta == JOptionPane.YES_OPTION) {
        VentanaApp.tickets.add( guiOrden.finalizarOrden() );
        System.out.println("Tickets: " + VentanaApp.tickets.toString());
        guiOrden.configurarComboMesas(false);
      }
    });

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
