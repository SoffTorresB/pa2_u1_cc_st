package ec.uce.edu.pa.paquete;
import ec.uce.edu.pa.paquete.Interceptors.Auditoria;
import jakarta.enterprise.context.ApplicationScoped;
 
@ApplicationScoped // Delego el control al contenedor ArC
// @RequestScoped //Aplicaciones web
// @Singleton //funcionalidad que no es lógica del negocio
public class PedidoService {
 
    @Auditoria
    public String realizar(Pedido pedido, String valor) {
 
        Long init = System.currentTimeMillis();
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
 
            e.printStackTrace();
        }
        System.out.println("realizando pedido...");
 
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
 
        System.out.println("Pedido realizado con éxito.");
 
        Long fin = System.currentTimeMillis()-init;
 
        return "Pedido realizado con éxito" + " tiempo de ejecucion= " + fin;
 
    }
 
}
 