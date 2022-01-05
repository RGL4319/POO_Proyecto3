package gui.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import gui.VentanaApp;
import gui.vistas.Inicio;
import modelos.Mesa;
import modelos.Orden;
import modelos.Platillo;
import modelos.Restaurante;
import modelos.usuarios.Usuario;

class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
    
    setBackground( new Color( 214, 32, 32 ) );
    setForeground( Color.WHITE );
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean isFocused,
      int row, int col) {

    setText((obj == null) ? "" : obj.toString());

    return this;
  }
}

class ButtonEditor extends DefaultCellEditor {

  protected JButton btn;
  private String label;
  private Boolean clicked;

  public ButtonEditor(JTextField txt) {
    super(txt);
    btn = new JButton();
    btn.setOpaque(true);
    
    btn.addActionListener(e -> {
      System.out.println("Eliminar");
      fireEditingStopped();
    });
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object obj, boolean arg2, int arg3, int arg4) {
    label = obj == null ? "" : obj.toString();
    btn.setText(label);
    clicked = true;
    return btn;
  }

  @Override
  public Object getCellEditorValue() {
    if (clicked) {
      // Eliminar platillo de orden
    }

    clicked = false;
    return new String(label);
  }

  @Override
  public boolean stopCellEditing() {
    clicked = false;
    return super.stopCellEditing();
  }
}

public class OrdenMesa extends JPanel {

  /**
   * El restaurante asociado a la vista
   */
  private Restaurante restaurante;

  /**
   * El usuario con sesión activa
   */
  private Usuario usuario;

  /**
   * El panel de inicio asociado al componente
   */
  private Inicio inicio;

  /**
   * La mesa asociada con la orden
   */
  private Mesa mesa;

  /**
   * El componente gráfico que despliega la tabla
   */
  private JTable tabla;

  /**
   * El modelo asociado con la tabla
   */
  private DefaultTableModel modelo;

  /**
   * Constructor de la clase
   *
   * @param restaurante el restaurante asociado al programa
   * @param mesa        la mesa de la orden
   */
  public OrdenMesa(Restaurante restaurante, Usuario usuario, Mesa mesa, Inicio inicio) {
    this.restaurante = restaurante;
    this.usuario = usuario;
    this.inicio = inicio;
    this.mesa = mesa;

    crearTabla();
  }

  public void crearTabla() {
    String[] identifier = { "Platillo", "Precio", "Cantidad", "Total", "Eliminar" };

    modelo = new DefaultTableModel() {

      @Override
      public boolean isCellEditable(int row, int column) {
        return column == 2 || column == 4;
      }
    };

    modelo.setColumnIdentifiers(identifier);

    tabla = new JTable();
    tabla.setModel(modelo);
    tabla.getTableHeader().setReorderingAllowed(false);

    tabla.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
    tabla.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField()));

    tabla.getModel().addTableModelListener(e -> {

      if (e.getColumn() != 2)
        return;

      String nombre = (String) tabla.getValueAt(e.getFirstRow(), 0);

      for (Platillo p : mesa.getOrden().getPlatillos().keySet()) {

        if (p.getNombre().equals(nombre)) {
          int num = 0;

          try {
            num = Integer.valueOf(tabla.getValueAt(e.getFirstRow(), 2).toString());
          } catch (NumberFormatException ex) {

          } finally {

            if (num < 1) {
              num = 1;
              tabla.setValueAt(num, e.getFirstRow(), 2);
            }

            mesa.getOrden().setNumDePlatillo(p, num);

            tabla.setValueAt(num * p.getPrecio(), e.getFirstRow(), 3);
          }
        }
      }
    });

    if (mesa != null && mesa.getOrden() != null) {

      Map<Platillo, Integer> platillos = mesa.getOrden().getPlatillos();
      for (Platillo platillo : platillos.keySet()) {
        Object[] data = { platillo.getNombre(), platillo.getPrecio(), platillos.get(platillo), platillo.getPrecio() * platillos.get(platillo), "Eliminar" };

        modelo.addRow(data);
      }
    }

    JScrollPane panel = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    removeAll();

    add(panel);
    
    panel.setPreferredSize(new Dimension(500, 200));
    VentanaApp.getInstancia().repaint();
  }

  public void agregarPlatillo(Platillo platillo) {
    if ( platillo == null )
      return;

    if (mesa.getOrden() == null) {
      mesa.setOrden(new Orden(usuario));

      int index = restaurante.getMesas().indexOf(mesa);
      restaurante.getMesas().get(index).ocupar();
      inicio.configurarComboMesas();
    }

    if (mesa.getOrden().getPlatillos().containsKey(platillo))
      return;

    Object[] data = { platillo.getNombre(), platillo.getPrecio(), 1, platillo.getPrecio(), "Eliminar" };

    modelo.addRow(data);

    mesa.getOrden().agregarPlatillo(platillo);
  }

  public void finalizarOrden() {
    // Se debe eliminar las filas de la tabla, cobrar generar ticket, y desocupar la mesa
    // tabla.removeRowSelectionInterval(0, tabla.getRowCount() - 1);
    System.out.println("Finalizó la orden. Se debe de cobrar.");
  }

  public void setMesa(Mesa mesa) {
    this.mesa = mesa;
  }
}
