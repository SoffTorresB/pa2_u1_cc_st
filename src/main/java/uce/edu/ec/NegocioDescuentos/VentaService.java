package uce.edu.ec.NegocioDescuentos;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped

public class VentaService {
    private final String id = UUID.randomUUID().toString();
    @Inject
    @Named("VIP")
    private CalculadoraDescuento descuentoVIP;
    @Inject
    private Auditoria auditoria;

    private CalculadoraDescuento descuentoRegular;

    // Inyeccion por constructor para DescuentoRegular, se utiliza @Named("regular")
    // para especificar que se inyecte la implementación de DescuentoRegular.
    @Inject
    public VentaService(@Named("regular") CalculadoraDescuento descuentoRegular) {
        this.descuentoRegular = descuentoRegular;
    }

    public String getId() {
        return id;
    }

    public double procesarVenta(int numeroVenta, String tipoCliente, double monto) {
        double descuento = 0.0;

        if ("VIP".equalsIgnoreCase(tipoCliente)) {
            descuento = descuentoVIP.calcular(monto);
        } else {
            descuento = descuentoRegular.calcular(monto);
        }

        double total = monto - descuento;

        // Registro mediante el componente de Auditoría (RT05, RT06)
        auditoria.registrar("Venta #" + numeroVenta + " | Tipo: " + tipoCliente +
                " | Monto: $" + monto + " | Descuento: $" + descuento +
                " | Total: $" + total + " | [VentaService ID: " + id + "]");

        return total;
    }
}
