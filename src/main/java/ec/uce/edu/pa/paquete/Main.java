package ec.uce.edu.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain

public class Main implements QuarkusApplication {
    @Inject
    private CitaService citaService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando la aplicación de citas médicas...");
        Cita cita = new Cita("Juan Aldana", "2023-07-15", "10:00 AM", "Consulta médica general", "persona1@gmail.com");
        this.citaService.guardarCita(cita);
        return 0;
    }
}
