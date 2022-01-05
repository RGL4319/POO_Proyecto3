package gui.vistas;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import gui.componentes.BusquedaPlatillos;
import gui.componentes.OrdenMesa;
import modelos.Mesa;
import modelos.Restaurante;
import modelos.usuarios.Usuario;

public class Inicio extends JPanel {

  /**
   * El restaurante asociado al programa
   */
  private Restaurante restaurante;

  /**
   * 
   */
  private OrdenMesa ordenMesa;

  /**
   * El selector de mesas
   */
  private JComboBox<Mesa> comboMesa;

  /**
   * CheckBox para activar/desactivar las mesas ocupadas
   */
  private JCheckBox checkFiltroOcupadas;

  /**
   * CheckBox para activar/desactivar las mesas desocupadas
   */
  private JCheckBox checkFiltroDesocupadas;

  /**
   * El usuario que tiene la sesión activa
   */
  private Usuario usuario;

  private BusquedaPlatillos busquedaPlatillos;

  /**
   * Constructor de la clase
   * 
   * @param usuario el usuario que tiene la sesión abierta
   */
  public Inicio(Restaurante restaurante, Usuario usuario) {
    this.restaurante = restaurante;
    this.usuario = usuario;

    crearComponentes();
  }

  public void crearComponentes() {
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    Box filtroMesas = Box.createHorizontalBox();

    checkFiltroDesocupadas = new JCheckBox("Desocupadas", true);
    checkFiltroOcupadas = new JCheckBox("Ocupadas", true);

    checkFiltroDesocupadas.addActionListener(e -> {
      if (!checkFiltroDesocupadas.isSelected() && !checkFiltroOcupadas.isSelected())
        checkFiltroDesocupadas.setSelected(true);
      configurarComboMesas(false);
    });
    checkFiltroOcupadas.addActionListener(e -> {
      if (!checkFiltroDesocupadas.isSelected() && !checkFiltroOcupadas.isSelected())
        checkFiltroOcupadas.setSelected(true);
      configurarComboMesas(false);
    });

    ordenMesa = new OrdenMesa(restaurante, usuario, null, this);
    busquedaPlatillos = new BusquedaPlatillos(restaurante, ordenMesa);
    configurarComboMesas(false);
    if (comboMesa.getItemCount() == 0) {
      // TODO: Manejo de ComboBox Vacío
    } else {
      comboMesa.setSelectedIndex(0);
    }

    filtroMesas.add(comboMesa);
    filtroMesas.add(checkFiltroOcupadas);
    filtroMesas.add(checkFiltroDesocupadas);

    add(filtroMesas);
    add(busquedaPlatillos);
    add(ordenMesa);
  }

  /**
   * Configura las opciones de la selección de mesas
   */
  public void configurarComboMesas(boolean mantenerSeleccion) {
    boolean ocupadas = checkFiltroOcupadas.isSelected();
    boolean desocupadas = checkFiltroDesocupadas.isSelected();
    Mesa anterior = null;

    if (comboMesa == null) {
      comboMesa = new JComboBox<>();
      comboMesa.addActionListener(e -> {
        if (comboMesa.isEnabled()) {
          ordenMesa.setMesa((Mesa) comboMesa.getSelectedItem());
          ordenMesa.crearTabla();
        }
      });
    } else {
      anterior = (Mesa) comboMesa.getSelectedItem();
    }

    comboMesa.setEnabled(false);
    comboMesa.removeAllItems();

    int numOcupadas, numDesocupadas;
    numOcupadas = numDesocupadas = 0;

    for (Mesa mesa : restaurante.getMesas()) {
      if (mesa.estaOcupada() && mesa.getOrden().getServidor().equals(usuario) && ocupadas) {
        comboMesa.addItem(mesa);
      } else if (!mesa.estaOcupada() && desocupadas) {
        comboMesa.addItem(mesa);
      }

      if (mesa.estaOcupada())
        numOcupadas++;
      else
        numDesocupadas++;
    }

    comboMesa.addItem(anterior);


    checkFiltroOcupadas.setText(String.format("Ocupadas (%d)", numOcupadas));
    checkFiltroDesocupadas.setText(String.format("Desocupadas (%d)", numDesocupadas));

    comboMesa.setEnabled(true);

    if (mantenerSeleccion) {
      comboMesa.setSelectedItem(anterior);
    } else {
      comboMesa.setSelectedIndex(0);
    }
  }
}
