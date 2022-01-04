package gui.vistas;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.VentanaApp;

public class Logout extends JPanel {

  public Logout() {
    super();
    crearComponentes();
  }

  private void crearComponentes() {
    Box contenedor = Box.createVerticalBox();
    contenedor.add(new JLabel("¿Seguro que quieres cerrar sesión?"));

    JPanel panelOpciones = new JPanel();
    panelOpciones.setLayout(new FlowLayout());

    JButton btnSi = new JButton("Sí");
    JButton btnNo = new JButton("No");

    btnSi.setBackground( new Color( 9, 150, 47 ) );
    btnNo.setBackground( Color.RED );
    btnSi.setForeground( Color.WHITE );
    btnNo.setForeground( Color.WHITE );

    btnSi.addActionListener(e -> {
      VentanaApp.getInstancia().crearLogin();
    });

    btnNo.addActionListener(e -> {
      VentanaApp.getInstancia().seleccionarTab(0);
    });

    panelOpciones.add(btnSi);
    panelOpciones.add(btnNo);

    contenedor.add(panelOpciones);

    add(contenedor);

    setBorder(BorderFactory.createEmptyBorder(75, 0, 75, 0));
  }
}
