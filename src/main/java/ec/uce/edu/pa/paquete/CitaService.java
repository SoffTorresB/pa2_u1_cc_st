package ec.uce.edu.pa.paquete;

import jakarta.inject.Inject;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

//@ApplicationScoped // delego el control al contenedor que es ArC
//@RequestScoped -> solo para aplicaciones web
@Singleton 
public class CitaService {
@Inject 
private MailService mailService;

     public void guardarCita(Cita cita) {
        // Lógica para guardar la cita en la base de datos o en un archivo
        System.out.println("Cita guardada para: " + cita.getNombre());
        System.out.println("Fecha: " + cita.getFecha());
        System.out.println("Hora: " + cita.getHora());
        System.out.println("Descripción: " + cita.getDescripcion());
        System.out.println("Correo: " + cita.getCorreo());

        String asunto = "Confirmación de cita médica";
        String mensaje = "Estimado paciente, su cita médica ha sido confirmada. Por favor, llegue 10 minutos antes de la hora programada. Gracias.";

        this.mailService.enviar(cita.getCorreo(), asunto, mensaje); // llamando al metodo enviar de la clase MailService
        
    }

}
