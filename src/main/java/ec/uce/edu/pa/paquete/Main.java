package ec.uce.edu.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private MatriculaService matriculaService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("---------------------------\nIniciando la app Quarkus\n---------------------------");
        Matricula matricula = new Matricula("Sofía Torres", "Programacion Avanzada II", 45.0, "sofia@uce.edu.ec",
                "0987654321");
        matriculaService.realizar(matricula, "");
        return 0;
    }
}