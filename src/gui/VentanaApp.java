package gui;

import java.awt.Color;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import gui.vistas.Inicio;
import gui.vistas.Login;
import modelos.Restaurante;
import modelos.usuarios.Administrador;
import modelos.usuarios.Usuario;

public class VentanaApp extends JFrame {

  private JTabbedPane panel;
  private JLabel nombreUsuario;

  private VentanaUsuarios buscador;
  private FormularioMesero formulario;

  private Restaurante restaurante;
  private Usuario usuario;

  private static VentanaApp instancia;

  public static VentanaApp getInstancia() {
    return instancia;
  }

  public static VentanaApp crearInstancia(Restaurante restaurante) {
    if (instancia == null)
      instancia = new VentanaApp(restaurante);
    
    return instancia;
  }

  private VentanaApp(Restaurante restaurante) {

    JPanel root = new JPanel();
    root.setLayout(new BorderLayout());

    nombreUsuario = new JLabel("");

    Box panelUsuario = Box.createHorizontalBox();
    panelUsuario.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
    panelUsuario.add(Box.createHorizontalGlue());
    panelUsuario.add(nombreUsuario);

    this.panel = new JTabbedPane();
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    root.add(panelUsuario, BorderLayout.NORTH);
    root.add(panel, BorderLayout.CENTER);

    getContentPane().add(root);

    this.restaurante = restaurante;
    this.usuario = null;

    crearLogin();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setTitle(restaurante.getNombre() + " - Iniciar sesión");

    setSize(400, 200);
    setResizable(false);
  }

  public void crearLogin() {
    nombreUsuario.setText("No hay usuario");
    nombreUsuario.setForeground(Color.RED);
    panel.removeAll();
    panel.add("Login", new Login(restaurante));
    setSize(500, 300);
    usuario = null;
  }

  public void crearSesion(Usuario usuario) {

    this.usuario = usuario;

    nombreUsuario.setText(this.usuario.getNombre());
    nombreUsuario.setForeground(new Color(0,250,30));

    panel.removeAll();
    panel.add("Inicio", new Inicio(restaurante, usuario));
    if ( usuario.esAdmin() ) {
      JPanel panelUsuarios = new JPanel();

      buscador = new VentanaUsuarios(restaurante, usuario);
      formulario = new FormularioMesero(restaurante);

      panelUsuarios.add(buscador);
      panelUsuarios.add(formulario);

      formulario.setVisible(false);

      panel.add( "Usuarios",  panelUsuarios);
    }

    JPanel panelLogout = new JPanel();
    Box contenedor = Box.createVerticalBox();
    contenedor.add( new JLabel("¿Seguro que quieres cerrar sesión?") );
    Box panelOpcionesLogout = Box.createHorizontalBox();
    JButton btnSi = new JButton("Sí");
    JButton btnNo = new JButton("No");
    btnSi.addActionListener( e -> {
      VentanaApp.getInstancia().crearLogin();
    } );
    panelOpcionesLogout.add(btnSi);
    panelOpcionesLogout.add(Box.createHorizontalStrut(20));
    panelOpcionesLogout.add(btnNo);
    contenedor.add( panelOpcionesLogout );
    panelLogout.add( contenedor );


    panel.add("Logout", panelLogout);
    // panel.addChangeListener( e -> {
    //   if ( panel.getTabCount() - panel.getSelectedIndex() == 1 ) {
    //     JOptionPane.showMessageDialog(null, "¿Seguro que quieres cerrar sesión?", "Question", JOptionPane.QUESTION_MESSAGE);
    //   }
    // } );
    setSize(600, 400);
  }

  public void toggleVistasUsuarios() {
      formulario.setVisible(!formulario.isVisible());
      buscador.setVisible(!buscador.isVisible());

      pack();
  }

  public FormularioMesero getFormulario() {
    return formulario;
  }
}
