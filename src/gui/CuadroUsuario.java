package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Restaurante;
import modelos.usuarios.Usuario;

public class CuadroUsuario{

    JButton btnEditar;
    Box contenedor;

    public CuadroUsuario ( Restaurante res, VentanaUsuarios ventana, Usuario usuario ) {
        contenedor = Box.createHorizontalBox();

        Box datos = Box.createVerticalBox();
        datos.add( new JLabel(String.format("Nombre: %s", usuario.getNombre())) );
        datos.add( new JLabel(String.format("Usuario: %s", usuario.getUsuario())) );
        datos.add( new JLabel(String.format("Edad: %d", usuario.getEdad())) );
        datos.add( new JLabel(String.format("Sexo: %c", usuario.getSexo())) );
        datos.add( new JLabel(String.format("Teléfono: %s", usuario.getTelefono())) );

        btnEditar = new JButton("Editar");

        btnEditar.addActionListener( e -> {
            ventana.dispose();
            FormularioMesero form = new FormularioMesero( res, usuario );
            form.pack();
            form.setVisible(true);
        } );

        contenedor.add(datos);
        // contenedor.add( Box.createHorizontalStrut(50) );
        contenedor.add(btnEditar);
    }

    public Box getContenedor() {
        return contenedor;
    }

}
