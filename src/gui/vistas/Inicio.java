package gui.vistas;

import java.awt.event.ItemEvent;

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

    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    Box filtroMesas = Box.createHorizontalBox();

    checkFiltroDesocupadas = new JCheckBox("Desocupadas", true);
    checkFiltroOcupadas = new JCheckBox("Ocupadas", true);

    checkFiltroDesocupadas.addActionListener(e -> {
      if (!checkFiltroDesocupadas.isSelected() && !checkFiltroOcupadas.isSelected())
        checkFiltroDesocupadas.setSelected(true);
      configurarComboMesas();
    });
    checkFiltroOcupadas.addActionListener(e -> {
      if (!checkFiltroDesocupadas.isSelected() && !checkFiltroOcupadas.isSelected())
        checkFiltroOcupadas.setSelected(true);
      configurarComboMesas();
    });

    
    ordenMesa = new OrdenMesa(restaurante, usuario, null, this);
    busquedaPlatillos = new BusquedaPlatillos(restaurante, ordenMesa);
    configurarComboMesas();
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
  public void configurarComboMesas() {
    boolean ocupadas = checkFiltroOcupadas.isSelected();
    boolean desocupadas = checkFiltroDesocupadas.isSelected();
    int anterior = -1;
    if (comboMesa == null) {
      comboMesa = new JComboBox<>();
      comboMesa.addActionListener(e -> {
        if (comboMesa.isEnabled()) {
          System.out.println(e.getSource());
          System.out.println(((Mesa)comboMesa.getSelectedItem())  + " :D");
          ordenMesa.setMesa((Mesa)comboMesa.getSelectedItem());
          ordenMesa.crearTabla();
        }
      });
    }
    else {
      anterior = comboMesa.getSelectedIndex();
    }

    comboMesa.setEnabled(false);
    comboMesa.removeAllItems();


    int numOcupadas, numDesocupadas;
    numOcupadas = numDesocupadas = 0;

    for (Mesa mesa : restaurante.getMesas()) {
      if (mesa.estaOcupada() && mesa.getOrden().getServidor().equals(usuario) && ocupadas) {
        comboMesa.addItem(mesa);
      }
      else if (!mesa.estaOcupada() && desocupadas) {
        comboMesa.addItem(mesa);
      }
      if ( mesa.estaOcupada() )
        numOcupadas++;
      else
        numDesocupadas++;
    }
    if ( anterior != -1 ) {
      comboMesa.setSelectedIndex(anterior);
    }

    checkFiltroOcupadas.setText( String.format("Ocupadas (%d)", numOcupadas) );
    checkFiltroDesocupadas.setText( String.format("Desocupadas (%d)", numDesocupadas) );

    

    comboMesa.setEnabled(true);

    
    // comboMesa.addItemListener(e -> {
    //   if (e.getStateChange() == ItemEvent.SELECTED) {
    //     System.out.println(((Mesa)e.getItem()).toString()  + " :D");
    //     ordenMesa.setMesa((Mesa)e.getItem());
    //     ordenMesa.crearTabla();
    //   }
    // });
  }
}
