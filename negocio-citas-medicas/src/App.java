import com.edu.ec.Cita;
import com.edu.ec.CitaService;

public class App {
    public static void main(String[] args) throws Exception {

        Cita cita = new Cita("Juan Aldana", "2023-07-15", "10:00 AM", "Consulta médica general", "persona1@gmail.com");

        CitaService citaService = new CitaService();
        citaService.guardarCita(cita);
        cita = null;
        citaService = null;

    }
}
