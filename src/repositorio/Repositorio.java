package repositorio;

import java.io.File;

public class Repositorio {
    private static final String ruta = new File("archivos/").getAbsolutePath();

    public static final String ARCHIVO_PLATILLOS = "platillos.rest";
    public static final String ARCHIVO_RESTAURANTE = "restaurante.rest";
    public static final String ARCHIVO_USUARIOS = "usuarios.rest";
    public static final String ARCHIVO_ORDENES = "ordens.rest";
    public static final String ARCHIVO_FACTURAS = "facturas.rest";

    public static String getRuta() {
        return ruta;
    }
}
