package repositorio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import modelos.*;
import modelos.usuarios.Usuario;

public class Repositorio {

    private static Repositorio instancia;
    private static final String ruta = new File("archivos/").getAbsolutePath();
    public static final String ARCHIVO_PLATILLOS = "platillos.rest";
    public static final String ARCHIVO_USUARIOS = "usuarios.rest";
    public static final String ARCHIVO_ORDENES = "ordens.rest";
    public static final String ARCHIVO_FACTURAS = "facturas.rest";

    private Repositorio() {
    }

    public static Repositorio getInstancia() {
        if (instancia == null)
            instancia = new Repositorio();
        return instancia;
    }

    public static List<Platillo> getPlatillos() {
        return null;
    }

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

    public static List<Mesa> getMesas(int numMesas) {
        List<Mesa> mesas = new LinkedList<>();
        for (int i = 1; i <= numMesas; i++)
            mesas.add(new Mesa(i));
        return mesas;
    }

    public static List<Ticket> getTickets() {
        return null;
    }

    public static String getRuta() {
        return ruta;
    }
}
