package ec.uce.edu.pa.paquete;

import ec.uce.edu.pa.paquete.extensiones.NotificacionExtension;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped 
public class CompraService {
   
    public void realizar(Compra compra, NotificacionExtension notificacionExtension) {


        System.out.println("realizando compra...");
        System.out.println("Compra realizado para el cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total: " + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        System.out.println("Compra realizado con éxito.");

        //aqui voy a programar el envio de la notificación
        notificacionExtension.enviar("Su pedido ha sido realizado con éxito", compra.getCliente());
    }

}