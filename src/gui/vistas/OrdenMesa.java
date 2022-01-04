package gui.vistas;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import modelos.Mesa;
import modelos.Orden;
import modelos.Platillo;
import modelos.Restaurante;
import modelos.usuarios.Usuario;

class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean isFocused, int row, int col) {

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
   * @param restaurante el restaurante asociado al programa
   * @param mesa la mesa de la orden
   */
  public OrdenMesa(Restaurante restaurante, Usuario usuario, Mesa mesa) {
    this.restaurante = restaurante;
    this.usuario = usuario;
    this.mesa = mesa;

    crearTabla();

    JScrollPane panel = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    panel.setPreferredSize(new Dimension(500, 200));
    add(panel);
  }

  private void crearTabla() {
    String[] identifier = {"Platillo", "Precio", "Cantidad", "Total", "Eliminar"};

    modelo = new DefaultTableModel() {

      @Override
      public boolean isCellEditable(int row, int column) {
        return column == 2 || column == 4;
      }
    };

    modelo.setColumnIdentifiers(identifier);

    tabla = new JTable();
    tabla.setModel(modelo);

    tabla.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
    tabla.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField()));

    tabla.getModel().addTableModelListener(e -> {

      if (e.getColumn() != 2)
        return;

      String nombre = (String)tabla.getValueAt(e.getFirstRow(), 0);

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
  }

  public void agregarPlatillo(Platillo platillo) {
    Object[] data = {platillo.getNombre(), platillo.getPrecio(), 1 , platillo.getPrecio(), "Eliminar"};

    if (mesa.getOrden() == null)
      mesa.setOrden(new Orden(usuario));

    modelo.addRow(data);

    mesa.getOrden().agregarPlatillo(platillo);
  }
}
