package ec.uce.edu.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
@ApplicationScoped 

public class CompraService {
    @Inject 
    @Named("mail")
    private Notificacion notificacionCorreo;
      public void realizar(Compra compra) {

        System.out.println("Realizando pedido... ");
        System.out.println("Pedido realizado para el cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total:" + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        System.out.println("Pedido realizado con éxito. ");

        // envio de mail
        String cuerpo = "Estimado " + compra.getCliente() + " su pedido de " +
                compra.getProducto() + " por un total de $" + compra.getTotal() +
                " ha sido realizado con éxito. ";
        // Notificacion del pedido por correo
        this.notificacionCorreo.enviar(compra.getCorreo(), cuerpo);
        this.notificacionCorreo.setCantidad(this.notificacionCorreo.getCantidad()+1);
        this.notificacionCorreo.getCantidad();
        System.out.println("Cantidad de correo enviados: "+ this.notificacionCorreo.getCantidad());
        System.out.println("Nombre: "+this.notificacionCorreo.getNombre());

    }

}
