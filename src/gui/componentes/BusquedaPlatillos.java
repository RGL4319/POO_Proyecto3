package gui.componentes;

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

    btnAgregar.addActionListener(e -> {
      Platillo pSeleccionado = (Platillo)busquedaPlatillos.getSelectedItem();
      if (busquedaPlatillos.getItemCount() > 0) {
        guiOrden.agregarPlatillo(pSeleccionado);
        busquedaPlatillos.removeItem(pSeleccionado);
      } else {
        JOptionPane.showMessageDialog(null, "Ya no hay más platillos", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    contenedor.add(labelBusqueda);
    contenedor.add(Box.createHorizontalStrut(5));
    contenedor.add(busquedaPlatillos);
    contenedor.add(Box.createHorizontalStrut(5));
    contenedor.add(btnAgregar);

    add(contenedor);
  }
}
