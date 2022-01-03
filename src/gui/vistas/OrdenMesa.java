package gui.vistas;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import gui.VentanaApp;
import modelos.Mesa;
import modelos.Platillo;
import modelos.Restaurante;

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
      System.out.println("Nada");
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
      System.out.println(label + " clicked!");
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
   * La mesa asociada con la orden
   */
  private Mesa mesa; 

  /**
   * El componente gráfico que despliega la tabla
   */
  private JTable tabla;

  public OrdenMesa(Restaurante restaurante, Mesa mesa) {
    this.restaurante = restaurante;
    this.mesa = mesa;

    crearTabla();
    JScrollPane panel = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    panel.setPreferredSize(new Dimension(500, 200));
    //panel.setSize(100, 100);
    //VentanaApp.getInstancia().pack();
    add(panel);
  }

  private void crearTabla() {
    String[] identifier = {"Platillo", "Precio", "Cantidad", "Eliminar"};
    DefaultTableModel modelo = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        return column == 2 || column == 3;
      }
    };

    modelo.setColumnIdentifiers(identifier);

    tabla = new JTable();
    tabla.setModel(modelo);

    tabla.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
    tabla.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField()));

    for (Platillo p : restaurante.getPlatillos()) {
      Object[] data = {p.getNombre(), p.getPrecio(), 1 ,  "Eliminar"};
      modelo.addRow(data);
    }
  }
}
