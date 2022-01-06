package gui.vistas;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JPanel;

import gui.componentes.Grafica;
import modelos.Mesa;
import modelos.Restaurante;
import modelos.Ticket;
import modelos.usuarios.Usuario;
import repositorio.RepositorioUsuarios;

public class Ventas extends JPanel {

  private Restaurante restaurante;

  public Ventas(Restaurante restaurante) {
    super();

    this.restaurante = restaurante;

    crearComponentes();
  }
  
  private void crearComponentes() {
    Box contenedorGrafica = Box.createHorizontalBox();

    Map<Usuario, Double> ventasMesero = new LinkedHashMap<>();
    Map<Mesa, Double> ventasMesa = new LinkedHashMap<>();

    List<Usuario> usuarios = RepositorioUsuarios.getUsuarios();

    for (Usuario u : usuarios) {
      ventasMesero.put(u, 0.0);
    }

    for (Ticket t : restaurante.getTickets()) {
      Usuario u = t.getOrden().getServidor();
      double avg = t.getTotal() + ventasMesero.get(u);

      ventasMesero.put(u, avg);
    }



    contenedorGrafica.add(new Grafica("Ventas totales por mesero", ventasMesero));
    contenedorGrafica.add(Box.createHorizontalStrut(30));
    //contenedorGrafica.add(new Grafica("Ventas totales por mesa", ventasMesa));

    add(contenedorGrafica);
  }
}
