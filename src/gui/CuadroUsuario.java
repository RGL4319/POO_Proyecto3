package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import modelos.Restaurante;
import modelos.usuarios.Usuario;

public class CuadroUsuario extends Box{

    JButton btnEditar;

    public CuadroUsuario ( Restaurante res, VentanaUsuarios ventana, Usuario usuario ) {

        super(BoxLayout.X_AXIS);

        Box datos = Box.createVerticalBox();
        datos.add( new JLabel(String.format("Nombre: %s", usuario.getNombre())) );
        datos.add( new JLabel(String.format("Usuario: %s", usuario.getUsuario())) );
        datos.add( new JLabel(String.format("Edad: %d", usuario.getEdad())) );
        datos.add( new JLabel(String.format("Sexo: %c", usuario.getSexo())) );
        datos.add( new JLabel(String.format("Teléfono: %s", usuario.getTelefono())) );

        btnEditar = new JButton("Editar");

        btnEditar.addActionListener( e -> {
            ventana.limpiarFormulario();
            VentanaApp.getInstancia().toggleVistasUsuarios();
            VentanaApp.getInstancia().getFormulario().setUsuario(usuario);

            VentanaApp.getInstancia().getFormulario().cargarDatosUsuario();

        } );

        add(datos);
        add(btnEditar);
    }
}
