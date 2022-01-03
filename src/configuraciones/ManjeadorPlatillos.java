package configuraciones;

import java.util.LinkedList;
import java.util.List;

import modelos.Platillo;

public class ManjeadorPlatillos {
  
  public static void reescribirArchivoPlatillos() {
    List<Platillo> platillos = new LinkedList<>();

    platillos.add(new Platillo("Mole de Olla", 12.5, "El tipico platillo"));
    platillos.add(new Platillo("Caldo de Pollo", 25.5, "El tipico platillo"));
  }
}
