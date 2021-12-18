 package configuraciones;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import modelos.Usuario;
import repositorio.Repositorio;

public class ManejadorUsuarios {
    /*Agregando usuarios nuevos*/
    public static void reescribirArchivoUsuarios () {
        List<Usuario> usuarios = new LinkedList<>();
        usuarios.add( new Usuario( 1, "Alfonso Perez", 30, 'H', "55-3444-3121", "Alfonso33", "Hola1" ) );
        usuarios.add( new Usuario( 2, "Antonio Chong", 30, 'H', "55-4564-2459", "Chong10", "Doggo10" ) );
        usuarios.add( new Usuario( 3, "Gabriela Luna", 30, 'H', "55-1144-3300", "Gaby123", "wola" ) );
        usuarios.add( new Usuario( 4, "Camilo Perez", 30, 'H', "55-4444-3321", "Camlo01", "Asw123" ) );
        usuarios.add( new Usuario( 5, "Julio Paredes", 33, 'H', "55-5564-2459", "Paredes24", "2410PJ" ) );
        usuarios.add( new Usuario( 6, "Camila Lopez", 28, 'M', "55-1112-3300", "CmLopez", "Lopz12" ) );
        try {
            ObjectOutputStream s = new ObjectOutputStream( new FileOutputStream(Repositorio.getRuta() + Repositorio.getArchivoUsuarios() ) );
            for ( Usuario usuario : usuarios) {
                s.writeObject( usuario );
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
