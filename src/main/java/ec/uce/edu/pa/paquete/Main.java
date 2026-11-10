package ec.uce.edu.pa.paquete;

import ec.uce.edu.pa.paquete.extensiones.NotificacionExtensionMail;
import ec.uce.edu.pa.paquete.extensiones.NotificacionExtensionSMS;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private PedidoService pedidoService;
    @Inject

    private CompraService compraService;
    @Inject

    private NotificacionExtensionMail notificacionExtensionMail;

    @Inject

    private NotificacionExtensionSMS notificacionExtensionSMS;
    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando aplicación Quarkus");
        Compra compra = new Compra("Sofía Torres", "Laptop", "satorresb1@gmail.com", 1200.00, "0996579476");

        compraService.realizar(compra, this.notificacionExtensionMail);


        Compra compra1 = new Compra("Sofía Torres", "Laptop", "satorresb1@gmail.com", 1200.00, "0996579476");

        compraService.realizar(compra1, this.notificacionExtensionSMS);
        return 0;
    }

}
