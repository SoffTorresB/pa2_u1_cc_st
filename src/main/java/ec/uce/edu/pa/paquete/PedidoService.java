package ec.uce.edu.pa.paquete;

//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

//@ApplicationScoped // delego el control al contenedor que es ArC
//@RequestScoped -> solo para aplicaciones web
@Singleton
public class PedidoService {

    // Inyeccion de dependencias por atributo

    /*
     * @Inject
     * private MailService mailService;
     */

    // private MailService mailService;

    // Inyeccion de dependencias por constructor

    /*
     * @Inject
     * public PedidoService(MailService mailService) {
     * 
     * this.mailService = mailService;
     * }
     */

    private MailService mailService;

    // Inyeccion de dependencia por método set

    @Inject
    public void setMailService(MailService mailService) {
        System.out.println("Se está inyectando el servico de email pedido service");
        this.mailService = mailService;
    }

    public void realizar(Pedido pedido) {

        System.out.println("Realizando pedido... ");

        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito. ");

        // envio de mail
        String asunto = "Confirmacion de pedido";
        String cuerpo = "Estimado " + pedido.getCliente() + " su pedido de " +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha sido realizado con éxito. ";
        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }

}
