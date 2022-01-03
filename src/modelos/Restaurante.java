package modelos;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {

  /**
   * El nombre del restaurante
   */
  private String nombre;

  /**
   * Las mesas del restaurente
   */
  private List<Mesa> mesas;

  /**
   * Constructor de la clase
   * @param nombre
   */
  public Restaurante(String nombre, int numMesas) {
    this.nombre = nombre;
    this.mesas = new ArrayList<>();

    for (int i = 1; i <= numMesas; i++)
      this.mesas.add(new Mesa(i));
  }

  /**
   * Método de acceso de consulta para el atributo 'nombre'
   * @return el nombre del restaurante
   */
  public String getNombre() {
    return nombre;
  }

  public List<Mesa> getMesas() {
    return mesas;
  }
}
