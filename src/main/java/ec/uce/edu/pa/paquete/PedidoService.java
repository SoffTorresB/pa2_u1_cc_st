package ec.uce.edu.pa.paquete;
import ec.uce.edu.pa.paquete.Interceptors.Auditoria;
import ec.uce.edu.pa.paquete.Interceptors.Mail;
import ec.uce.edu.pa.paquete.Interceptors.MedirTiempo;
import ec.uce.edu.pa.paquete.Interceptors.SMS;
import jakarta.enterprise.context.ApplicationScoped;
 
@ApplicationScoped // Delego el control al contenedor ArC
// @RequestScoped //Aplicaciones web
// @Singleton //funcionalidad que no es lógica del negocio
public class PedidoService {
    //3: ENVIO DE sms //4: mail

    @Mail 
    @SMS 
    @Auditoria//2
    @MedirTiempo //1
    
    public String realizar(Pedido pedido, String valor) {
 
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
 
        }
        System.out.println("realizando pedido...");
 
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
 
        System.out.println("Pedido realizado con éxito.");

 
        return "Pedido realizado con éxito" ;
 
    }
 
}
 