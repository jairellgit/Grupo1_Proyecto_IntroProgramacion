import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ModuloDeReportes {
    private Registro registro;
    private Organizar organizar;
    private Comprar comprar;

    // Constructor que recibe instancias de Registro, Organizar y Comprar
    public ModuloDeReportes(Registro registro, Organizar organizar, Comprar comprar) {
        this.registro = registro;
        this.organizar = organizar;
        this.comprar = comprar;
    }

    // mostrar productos disponibles
    public void reporteProductosDisponibles() {
        String[] productos = registro.getProductos();
        StringBuilder mensaje = new StringBuilder("Productos Disponibles:\n");

        for (String producto : productos) {
            mensaje.append("- ").append(producto).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Productos Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    //   organización de pasillos
    public void reporteOrganizacionPasillos() {
        int[][] organizacion = organizar.getOrganizacion();
        StringBuilder mensaje = new StringBuilder("Organización de Pasillos:\n");

        for (int i = 0; i < organizacion.length; i++) {
            for (int j = 0; j < organizacion[i].length; j++) {
                mensaje.append(organizacion[i][j]).append("\t");
            }
            mensaje.append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Organización de Pasillos", JOptionPane.INFORMATION_MESSAGE);
    }

    //  productos próximos a caducar
    public void reporteCaducidadProductos() {
        Date[] fechasCaducidad = registro.getFechasCaducidad();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder mensaje = new StringBuilder("Productos Próximos a Caducar:\n");

        Date fechaActual = new Date(); 

        for (int i = 0; i < fechasCaducidad.length; i++) {
            if (fechasCaducidad[i] != null && fechasCaducidad[i].before(fechaActual)) {
                mensaje.append(registro.getProductos()[i]).append(" - Caduca el ").append(formatter.format(fechasCaducidad[i])).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Productos Próximos a Caducar", JOptionPane.WARNING_MESSAGE);
    }

    // resumen de compras
    public void reporteResumenCompras() {
        int totalComprasRealizadas = comprar.obtenerTotalComprasRealizadas();
        double totalMontoComprado = comprar.obtenerTotalMontoComprado();

        String mensaje = String.format("Resumen de Compras:\n\nTotal de compras realizadas: %d\nTotal gastado: $%.2f", totalComprasRealizadas, totalMontoComprado);

        JOptionPane.showMessageDialog(null, mensaje, "Resumen de Compras", JOptionPane.INFORMATION_MESSAGE);
    }

   
}
