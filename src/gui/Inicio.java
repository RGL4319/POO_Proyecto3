package gui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelos.Mesa;
import modelos.Restaurante;
import modelos.usuarios.Usuario;

public class Inicio extends JFrame {

    /**
     * El restaurante asociado al programa
     */
    private Restaurante restaurante;

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

    /**
     * Constructor de la clase
     * @param usuario el usuario que tiene la sesión abierta
     */
    public Inicio ( Restaurante restaurante, Usuario usuario ) {
        super(restaurante.getNombre() + " - Inicio");

        this.restaurante = restaurante;
        this.usuario = usuario;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo( null );

        JPanel root = new JPanel();
        root.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

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

        configurarComboMesas();

        comboMesa.addActionListener((e) -> {
            System.out.println(comboMesa.getSelectedItem());
        });

        filtroMesas.add(comboMesa);
        filtroMesas.add(checkFiltroOcupadas);
        filtroMesas.add(checkFiltroDesocupadas);

        root.add(filtroMesas);

        getContentPane().add(root);
    }

    /**
     * Configura las opciones de la selección de mesas
     */
    private void configurarComboMesas() {
        boolean ocupadas = checkFiltroOcupadas.isSelected();
        boolean desocupadas = checkFiltroDesocupadas.isSelected();

        if (comboMesa == null)
            comboMesa = new JComboBox<>();
        
        comboMesa.removeAllItems();

        for (Mesa mesa : restaurante.getMesas()) {
            if (mesa.estaOcupada() && mesa.getOrden().getServidor().equals(usuario) && ocupadas)
                comboMesa.addItem( mesa );
            else if (!mesa.estaOcupada() && desocupadas)
                comboMesa.addItem( mesa );
        }

        if (comboMesa.getItemCount() == 0) {
            // TODO: Manejo de ComboBox Vacío
        } else {
            comboMesa.setSelectedIndex(0);
        }
    }
}
