package gui.componentes;

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
    Box contenedor = Box.createVerticalBox();

    Box panelBusqueda = Box.createHorizontalBox();
    busquedaPlatillos = new JComboBox<>();

    descripcion = new JLabel("");

    for (Platillo p : restaurante.getPlatillos()) {
      busquedaPlatillos.addItem(p);
    }

    busquedaPlatillos.setEditable(true);
    busquedaPlatillos.setSelectedItem(null);

    JButton btnAgregar = new JButton("Agregar");

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

    panelBusqueda.add(labelBusqueda);
    panelBusqueda.add(Box.createHorizontalStrut(5));
    panelBusqueda.add(busquedaPlatillos);
    panelBusqueda.add(Box.createHorizontalStrut(5));
    panelBusqueda.add(btnAgregar);

    contenedor.add(panelBusqueda);
    contenedor.add(descripcion);

    add(contenedor);
  }
}
