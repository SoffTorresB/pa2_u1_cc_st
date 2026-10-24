package ec.uce.edu.pa.paquete;

//import jakarta.enterprise.inject.spi.CDI;
import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
//import jakarta.inject.Singleton;
import jakarta.inject.Named;

@ApplicationScoped // delego el control al contenedor que es ArC
//@RequestScoped -> solo para aplicaciones web
//@Singleton
public class PedidoService {

    @Inject
    @Named("mail")

    private MailService notificacionCorreo;
    @Inject
    @Named("sms")

    private SMSService notificacionSMS;

    public void realizar(Pedido pedido) {

        System.out.println("Realizando pedido... ");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito. ");

        // envio de mail
        String cuerpo = "Estimado " + pedido.getCliente() + " su pedido de " +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha sido realizado con éxito. ";
        // Notificacion del pedido por correo
        this.notificacionCorreo.enviar(pedido.getCorreo(), cuerpo);
        this.notificacionCorreo.setCantidad(this.notificacionCorreo.getCantidad()+1);
        this.notificacionCorreo.setNombre("Correo de pedido");

        // Notificacion del pedido por SMS
        this.notificacionSMS.enviar(pedido.getTelefono(), cuerpo);
    }
}
