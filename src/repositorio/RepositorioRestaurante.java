package repositorio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

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
}
