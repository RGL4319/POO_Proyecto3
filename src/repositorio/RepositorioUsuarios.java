package repositorio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import modelos.usuarios.Usuario;

public class RepositorioUsuarios {

    public static List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new LinkedList<>();
        File ruta = new File(new File(Repositorio.getRuta()), Repositorio.ARCHIVO_USUARIOS);

        try (ObjectInputStream s = new ObjectInputStream(new FileInputStream(ruta))) {

            Usuario usuario = null;

            do {
                usuario = (Usuario) s.readObject();
                usuarios.add(usuario);

            } while (usuario != null);

        } catch (EOFException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
