package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IniciarSesion extends JFrame {
    
    private JTextField campoUsuario;
    private JPasswordField campoContrasenia;
    private JLabel etiquetaUsuario, etiquetaContrasenia;
    private JPanel panelCampos;
    private JCheckBox checkMostrarContrasenia;
    private JButton btnIngresar;
    
    private char puntito;

    public IniciarSesion () {
        super();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize( new Dimension(800, 600) );
        setLocationRelativeTo( null );
        setTitle("NOMBRE RESTAURANTE - Iniciar sesión");
        panelCampos = new JPanel();
        panelCampos.setLayout( new FlowLayout() );
        campoUsuario = new JTextField();
        campoUsuario.setColumns(20);
        campoContrasenia = new JPasswordField();
        campoContrasenia.setColumns(20);
        etiquetaUsuario = new JLabel("Usuario");
        etiquetaContrasenia = new JLabel("Contraseña");
        checkMostrarContrasenia = new JCheckBox("Mostrar contarseña");
        puntito = campoContrasenia.getEchoChar();
        btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener( new ActionListener () {
            public void actionPerformed ( ActionEvent e ) {
                if ( esUsuario() ) {
                    JOptionPane.showMessageDialog(null, "¡Ingresaste!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
                }
            }
        } );
        checkMostrarContrasenia.addActionListener( new ActionListener() {
            public void actionPerformed ( ActionEvent e ) {
                alternarVistaContrasenia();
            }
        } );
        panelCampos.add( etiquetaUsuario );
        panelCampos.add( campoUsuario );
        panelCampos.add( etiquetaContrasenia );
        panelCampos.add( campoContrasenia );
        panelCampos.add( checkMostrarContrasenia );
        panelCampos.add( btnIngresar );
        add( new JLabel("IMAGEN"), BorderLayout.NORTH );
        add( panelCampos, BorderLayout.CENTER );
    }

    private boolean esUsuario () {
        return true;
    }

    private void alternarVistaContrasenia () {
        campoContrasenia.setEchoChar( ( !checkMostrarContrasenia.isSelected() ? puntito : (char)0 ) );
    }

}
