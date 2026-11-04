package ec.uce.edu.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private PedidoService pedidoService;

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando aplicación Quarkus");

        // Creamos manualmente el objeto de la clase pedido
        Pedido pedido = new Pedido("Juan Pérez", "Laptop", 1500.00, "0991677893");

        pedidoService.realizar(pedido, "valor1");

        return 0;
    }

}
