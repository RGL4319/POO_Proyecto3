package repositorio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelos.Restaurante;

public class RepositorioRestaurante {
  public static Restaurante getRestaurante() {

    Restaurante restaurante = null;
    File ruta = new File(new File(Repositorio.getRuta()), Repositorio.ARCHIVO_RESTAURANTE);

    try (ObjectInputStream s = new ObjectInputStream(new FileInputStream(ruta))) {
      restaurante = (Restaurante) s.readObject();
    } catch (EOFException e) {
    } catch (Exception e) {
      e.printStackTrace();
    }

    return restaurante;
  }

  

  public static void guardar( Restaurante restaurante ) {
    try {
      File ruta = new File(new File(Repositorio.getRuta()), Repositorio.ARCHIVO_RESTAURANTE);
      ObjectOutputStream s = new ObjectOutputStream( new FileOutputStream(ruta) );
      s.writeObject(restaurante);
      s.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
