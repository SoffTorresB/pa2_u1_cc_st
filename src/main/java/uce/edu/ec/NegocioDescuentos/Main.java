package uce.edu.ec.NegocioDescuentos;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain

public class Main implements QuarkusApplication {

    @Inject
    private VentaService ventaService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Iniciando aplicacion Quarkus");
        System.out.println("========== SIMULADOR DE DESCUENTOS QUARKUS ==========");
        ventaService.procesarVenta(1, "REGULAR", 100.00);
        ventaService.procesarVenta(2, "VIP", 200.00);
        ventaService.procesarVenta(3, "REGULAR", 300.00);
        ventaService.procesarVenta(4, "VIP", 500.00);

        System.out.println("=====================================================");
        return 0;
    }

}
