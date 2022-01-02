package gui;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelos.Usuario;
import repositorio.Repositorio;

public class Login extends JFrame {

    /**
     * Campo para capturar el usuario
     */
    private JTextField campoUsuario;

    /**
     * Campo para capturar la contraseña
     */
    private JPasswordField campoPassword;

    /**
     * Opción para mostrar/ocultar contraseña
     */
    private JCheckBox mostrarPassword;

    /**
     * Botón para hacer login
     */
    private JButton botonLogin;

    /**
     * Caracter que se muestra en el compo de la contraseña
     */
    private char puntito;

    /**
     * Constructor de la clase
     */
    public Login() {
        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("COCINA MEXICANA - Iniciar sesión");

        crearComponentes();

        setResizable(false);
    }

    /**
     * Se encarga de construir y configurar todos los componentes de fomulario de
     * login
     */
    private void crearComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Creación del campo para el 'usuario'
        Box panelUsuario = Box.createHorizontalBox();

        campoUsuario = new JTextField();
        campoUsuario.setColumns(20);
        JLabel etiquetaUsuario = new JLabel("Usuario");
        etiquetaUsuario.setLabelFor(campoUsuario);

        panelUsuario.add(etiquetaUsuario);
        panelUsuario.add(Box.createHorizontalStrut(20));
        panelUsuario.add(campoUsuario);

        // Creación del campo para la 'contraseña'
        Box panelPassword = Box.createHorizontalBox();

        campoPassword = new JPasswordField();
        campoPassword.setColumns(20);
        JLabel etiquetaPassword = new JLabel("Contraseña");
        etiquetaPassword.setLabelFor(campoPassword);

        puntito = campoPassword.getEchoChar();

        panelPassword.add(etiquetaPassword);
        panelPassword.add(Box.createHorizontalStrut(20));
        panelPassword.add(campoPassword);

        // Opción de 'ver contraseña' y botón de 'login'
        Box panelControl = Box.createHorizontalBox();

        mostrarPassword = new JCheckBox("Mostrar contraseña");
        mostrarPassword.addActionListener((e) -> {
            campoPassword.setEchoChar((!mostrarPassword.isSelected() ? puntito : 0));
        });

        // Creación del botón de login
        botonLogin = new JButton("Login");
        botonLogin.addActionListener((e) -> {
            Usuario usuario = obtenerUsuario();
            if (usuario != null) {
                // JOptionPane.showMessageDialog(null, "¡Ingresaste!");
                dispose();
                new Inicio(usuario);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
            }
        });

        panelControl.add(mostrarPassword);
        panelControl.add(Box.createHorizontalStrut(20));
        panelControl.add(botonLogin);

        panel.add(panelUsuario);
        panel.add(Box.createVerticalStrut(30));
        panel.add(panelPassword);
        panel.add(Box.createVerticalStrut(30));
        panel.add(panelControl);

        panel.setBorder(BorderFactory.createEmptyBorder(35, 35, 30, 30));

        getContentPane().add(panel);
    }

    /**
     * Retorna el usuario asociado con las credenciales proporcionadas en el login
     *
     * @return el usuario que coincide
     */
    private Usuario obtenerUsuario() {
        List<Usuario> usuarios = Repositorio.getUsuarios();

        String usuario = campoUsuario.getText();
        String password = new String(campoPassword.getPassword());

        for (Usuario u : usuarios) {
            if (u.verificarUsuario(usuario, password))
                return u;
        }
        return null;
    }
}
