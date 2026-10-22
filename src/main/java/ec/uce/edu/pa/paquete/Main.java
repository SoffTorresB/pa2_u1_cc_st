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
        System.out.println("Iniciando aplicacion Quarkus");

        Pedido pedido = new Pedido("Juan Pérez", "laptop", 1500.00, "jp123@gmail.com");// creamos manualmente el objeto
        pedido.setTelefono("0996579493");                                                                               // de la clase Pedido
        this.pedidoService.realizar(pedido);

        return 0;
    }

}
