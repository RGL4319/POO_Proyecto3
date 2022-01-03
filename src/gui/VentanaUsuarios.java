package gui;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelos.Restaurante;
import modelos.usuarios.Usuario;
import repositorio.RepositorioUsuarios;

public class VentanaUsuarios extends JPanel {
    
    private Restaurante restaurante;
    private Usuario usuario;
    private List<Usuario> usuarios;
    private boolean editar;
    private String busqueda;
    private VentanaUsuarios me;

    private JTextField campoBusqueda;
    private JButton btnBuscar;
    private JButton btnCrearUsuario;
    private JComboBox<String> filtros;
    private Box panelResultados;

    public VentanaUsuarios ( Restaurante restaurante, Usuario usuario ) {
        super();

        this.restaurante = restaurante;
        this.usuario = usuario;
        this.editar = usuario != null;
        me = this;

        crearComponentes();
    }

    private void crearComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        Box panelIzquierdo = Box.createVerticalBox();

        Box panelBusqueda = Box.createHorizontalBox();

        campoBusqueda = new JTextField();
        campoBusqueda.setColumns(20);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener((e) -> {
            cargarUsuarios();
        });

        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(Box.createHorizontalStrut(30));
        panelBusqueda.add( btnBuscar );

        Box panelFiltro = Box.createHorizontalBox();
        filtros = new JComboBox<>();
        filtros.addItem( "Nombre" );
        filtros.addItem( "Usuario" );
        filtros.addItem( "Teléfono" );
        filtros.setSelectedIndex(0);
        JLabel etiquetaFiltro = new JLabel("Buscar por");
        etiquetaFiltro.setLabelFor(filtros);

        panelFiltro.add( etiquetaFiltro );
        panelFiltro.add(Box.createHorizontalStrut(30));
        panelFiltro.add( filtros );

        btnCrearUsuario = new JButton("Crear usuario");
        btnCrearUsuario.addActionListener( e -> {
            VentanaApp.getInstancia().toggleVistasUsuarios();
            VentanaApp.getInstancia().getFormulario().setUsuario(null);
        } );

        panelIzquierdo.add( panelBusqueda );
        panelIzquierdo.add(Box.createVerticalStrut(10));
        panelIzquierdo.add( panelFiltro );
        panelIzquierdo.add(Box.createVerticalStrut(10));
        panelIzquierdo.add( btnCrearUsuario );

        Box panelDerecho = Box.createVerticalBox();
        
        panelResultados = Box.createVerticalBox();
        // JScrollPane scrollPane = new JScrollPane( panelResultados );
        // scrollPane.setMaximumSize( new Dimension( 100, 100 ) );
        panelDerecho.add( panelResultados );


        panel.add( panelIzquierdo );
        panel.add(Box.createHorizontalStrut(30));
        panel.add( panelDerecho );

        panel.setBorder(BorderFactory.createEmptyBorder(35, 35, 30, 30));

        add(panel);

    }

    private void cargarUsuarios () {
        panelResultados.removeAll();
        for ( Usuario usuario: RepositorioUsuarios.getUsuarios()) {
            switch ( filtros.getSelectedItem().toString() ) {
                case "Nombre":
                    if ( usuario.getNombre().equals( campoBusqueda.getText() ) ) {
                        panelResultados.add( new CuadroUsuario( restaurante, me, usuario ) );
                    }
                    break;
            
                case "Usuario":
                    if ( usuario.getUsuario().equals( campoBusqueda.getText() ) ) {
                        panelResultados.add( new CuadroUsuario( restaurante, me, usuario ) );
                    }
                    break;
            
                case "Teléfono":
                    if ( usuario.getTelefono().equals( campoBusqueda.getText() ) ) {
                        panelResultados.add( new CuadroUsuario( restaurante, me, usuario ) );
                    }
                    break;
            
                default:
                    break;
            }
        }
        VentanaApp.getInstancia().pack();
        repaint();
    }
}
