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
    
    private JTextField campoUsuario;
    private JPasswordField campoPassword;
    private JLabel etiquetaUsuario, etiquetaPassword;
    private JCheckBox mostrarPassword;
    private JButton botonLogin;
    
    private char puntito;

    public Login () {
        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo( null );
        setTitle("NOMBRE RESTAURANTE - Iniciar sesión");
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Creación del campo para el 'usuario'
        Box panelUsuario = Box.createHorizontalBox();

        campoUsuario = new JTextField();
        campoUsuario.setColumns(20);
        etiquetaUsuario = new JLabel("Usuario");
        etiquetaUsuario.setLabelFor(campoUsuario);

        panelUsuario.add(etiquetaUsuario);
        panelUsuario.add(Box.createHorizontalStrut(20));
        panelUsuario.add(campoUsuario);

        // Creación del campo para la 'contraseña'
        Box panelPassword = Box.createHorizontalBox();

        campoPassword = new JPasswordField();
        campoPassword.setColumns(20);
        etiquetaPassword = new JLabel("Contraseña");
        etiquetaPassword.setLabelFor(campoPassword);

        puntito = campoPassword.getEchoChar();

        panelPassword.add(etiquetaPassword);
        panelPassword.add(Box.createHorizontalStrut(20));
        panelPassword.add(campoPassword);

        // Opción de 'ver contraseña' y botón de 'login'
        Box panelControl = Box.createHorizontalBox();

        mostrarPassword = new JCheckBox("Mostrar contraseña");
        mostrarPassword.addActionListener((e) -> {
            campoPassword.setEchoChar( ( !mostrarPassword.isSelected() ? puntito : 0 ) );
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

        setResizable(false);
    }

    private Usuario obtenerUsuario () {
        List<Usuario> usuarios = Repositorio.getUsuarios();
        for (Usuario usuario : usuarios) {
            if ( usuario.verificarUsuario( campoUsuario.getText(), new String( campoPassword.getPassword() ) ) )
                return usuario;
        }
        return null;
    }
}
