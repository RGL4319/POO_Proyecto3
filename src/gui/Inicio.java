package gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelos.Mesa;
import modelos.usuarios.Usuario;

public class Inicio extends JFrame {

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
    public Inicio ( Usuario usuario ) {
        super("COCINA MEXICANA - Inicio");
        this.usuario = usuario;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo( null );

        JPanel root = new JPanel();
        root.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        Box filtroMesas = Box.createHorizontalBox();

        checkFiltroDesocupadas = new JCheckBox("Desocupadas");
        checkFiltroOcupadas = new JCheckBox("Ocupadas");

        configurarComboMesas();

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
        if (comboMesa == null)
            comboMesa = new JComboBox<>();

        List<Mesa> mesas = new LinkedList<>();

        mesas.add( new Mesa( 1 ) );
        mesas.add( new Mesa( 2 ) );
        mesas.add( new Mesa( 3 ) );

        for (Mesa mesa : mesas) {
            comboMesa.addItem( mesa );
        }

        comboMesa.addActionListener((e) -> {
            System.out.println(comboMesa.getSelectedItem());
        });

        comboMesa.setSelectedIndex(0);
    }
}
