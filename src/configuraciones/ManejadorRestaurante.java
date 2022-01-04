package configuraciones;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import modelos.Platillo;
import modelos.Restaurante;
import repositorio.Repositorio;

public class ManejadorRestaurante {

  public static void reescribirArchivo() {
    Restaurante res = new Restaurante("COCINA MEXICANA", 8);

    res.agregarPlatillo(new Platillo("Sopa del día", 70, "Puede elegir entre pierna, muslo o rabadilla"));
    res.agregarPlatillo(new Platillo("Arroz", 30, "Arroz rojo o blanco"));
    res.agregarPlatillo(new Platillo("Spaghetti", 32, "Rojo o blanco según el día"));
    res.agregarPlatillo(new Platillo("Enchiladas", 120, "Tortillas con salsa"));
    res.agregarPlatillo(new Platillo("Mole", 120, "Un platillo típico de México"));
    res.agregarPlatillo(new Platillo("Milanesa", 70, "Un platillo tipico de México 1"));
    res.agregarPlatillo(new Platillo("Arrachera", 70, "Un platillo bien tipico de México"));
    res.agregarPlatillo(new Platillo("Tacos Dorados", 65, "Tortilla con carne, lechuga, crema y queso"));
    res.agregarPlatillo(new Platillo("Agua de frutas", 15, "Agua fresca, llévele llévele"));
    res.agregarPlatillo(new Platillo("Agua de frutas", 15, "Agua fresca, llévele llévele"));
    res.agregarPlatillo(new Platillo("Agua de frutas", 15, "Agua fresca, llévele llévele"));
    res.agregarPlatillo(new Platillo("Agua de frutas", 15, "Agua fresca, llévele llévele"));
    res.agregarPlatillo(new Platillo("Agua de frutas", 15, "Agua fresca, llévele llévele"));

    try {
        File ruta = new File(new File(Repositorio.getRuta()), Repositorio.ARCHIVO_RESTAURANTE);
        ObjectOutputStream s = new ObjectOutputStream( new FileOutputStream(ruta) );
        s.writeObject(res);
        s.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
