package repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

    private Repositorio () {}

    public static Repositorio getInstancia () {
        if ( instancia == null )
            instancia = new Repositorio();
        return  instancia;
    }

    public static List<Platillo> getPlatillos () {
        return null;
    }

    public static List<Usuario> getUsuarios () {
        List<Usuario> usuarios = new LinkedList<>();
        try {
            ObjectInputStream s = new ObjectInputStream( new FileInputStream( ruta + ARCHIVO_USUARIOS) );
            Usuario usuario;
            usuario = (Usuario) s.readObject();
          //  System.out.println(usuario);
            while ( usuario != null ) {
                usuario = (Usuario) s.readObject();
                usuarios.add( usuario );
            }
            s.close();
            //Agregando el IOException para que no marque ninguna el programa. 
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
         catch (Exception e) {
            e.printStackTrace();
            return usuarios;
        }
        return usuarios;
    }

    public static List<Mesa> getMesas ( int numMesas ) {
        List<Mesa> mesas = new LinkedList<>();
        for (int i = 1; i <= numMesas; i++)
            mesas.add( new Mesa(i) );
        return mesas;
    }

    public static List<Ticket> getTickets () {
        return null;
    }

    public static List<Factura> getFacturas () {
        return null;
    }

    public static String getRuta() {
        return ruta;
    }
}
