package modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
   * Los platillos del restaurante
   */
  private Set<Platillo> platillos;

  /**
   * Constructor de la clase
   * 
   * @param nombre
   */
  public Restaurante(String nombre, int numMesas) {
    this.nombre = nombre;
    this.mesas = new ArrayList<>();
    this.platillos = new HashSet<>();

    for (int i = 1; i <= numMesas; i++)
      this.mesas.add(new Mesa(i));
  }

  /**
   * Método de acceso de consulta para el atributo 'nombre'
   * 
   * @return el nombre del restaurante
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Método de acceso de consulta para el atributo 'mesas'
   * 
   * @return una lista con las mesas
   */
  public List<Mesa> getMesas() {
    return mesas;
  }

  /**
   * Método de acceso de consulta para el atributo 'platillos'
   * 
   * @return una lista con los platillos
   */
  public Set<Platillo> getPlatillos() {
    return platillos;
  }

  /**
   * Agrega un platillo al registro interno del restaurante y retorna
   * un booleano que indica el éxito de la operación.
   *
   * @param platillo el platillo a insertar
   * @return 'true' en caso de que se haya agregado con éxito, 'false'
   *         de lo contrario
   */
  public boolean agregarPlatillo(Platillo platillo) {
    return platillos.add(platillo);
  }
}
