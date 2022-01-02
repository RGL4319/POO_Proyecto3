package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modelos.Mesa;
import modelos.usuarios.Administrador;
import modelos.usuarios.Usuario;

public class Inicio extends JFrame {
    
    private JPanel panelIzquierda;
    private JPanel panelDerecha;
    private JPanel panelBotones;
    private JLabel etiquetaUsuario;
    private JComboBox<Mesa> comboMesa;
    private JLabel etiquetaFiltros;
    ButtonGroup grupoFiltros;

    
    private Usuario usuario;

    public Inicio ( Usuario usuario ) {
        super();
        this.usuario = usuario;
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize( new Dimension(800, 600) );
        setLocationRelativeTo( null );
        setTitle("NOMBRE RESTAURANTE - Inicio   ");

        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        panelBotones = new JPanel();
        panelBotones.setLayout( new FlowLayout() );


        etiquetaUsuario = new JLabel( usuario.getNombre() );
        comboMesa = new JComboBox<Mesa>();

        List<Mesa> mesas = new LinkedList<>();
        mesas.add( new Mesa( 1 ) );
        mesas.add( new Mesa( 2 ) );
        mesas.add( new Mesa( 3 ) );
        for (Mesa mesa : mesas) {
            comboMesa.addItem( mesa );
        }
        comboMesa.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboMesa.getSelectedItem());
                
            }
        } );
        comboMesa.setSelectedIndex(0);
        etiquetaFiltros = new JLabel("Filtros de mesa");
        grupoFiltros = new ButtonGroup();
        JRadioButton filtro1 = new JRadioButton("Todos", true);
        grupoFiltros.add( filtro1 );
        JRadioButton filtro2 = new JRadioButton("Ocupadas");
        grupoFiltros.add( filtro2 );
        JRadioButton filtro3 = new JRadioButton("Desocupadas");
        grupoFiltros.add( filtro3 );
        panelBotones.add(comboMesa);
        panelBotones.add(etiquetaFiltros);
        panelBotones.add( filtro1 );
        panelBotones.add( filtro2 );
        panelBotones.add( filtro3 );

        panelIzquierda.add( etiquetaUsuario, BorderLayout.NORTH );
        panelIzquierda.add( panelBotones, BorderLayout.CENTER );
        

        add( panelIzquierda, BorderLayout.WEST );
        add( panelDerecha, BorderLayout.EAST );
    }

    private boolean esAdmin() {
        return usuario instanceof Administrador;
    }
}
