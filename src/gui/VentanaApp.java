package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gui.vistas.Inicio;
import gui.vistas.Login;
import modelos.Restaurante;
import modelos.usuarios.Usuario;

public class VentanaApp extends JFrame {

  private JTabbedPane panel;
  private JLabel nombreUsuario;

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
  }

  public void crearSesion(Usuario usuario) {

    this.usuario = usuario;

    nombreUsuario.setText(this.usuario.getNombre());
    nombreUsuario.setForeground(new Color(0,250,30));

    panel.removeAll();
    panel.add("Inicio", new Inicio(restaurante, usuario));
    panel.add("Logout", new JPanel());
    setSize(600, 400);
  }
}
