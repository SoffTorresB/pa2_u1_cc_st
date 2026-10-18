package com.edu.ec;

public class CitaService {

    public void guardarCita(Cita cita) {
        // Lógica para guardar la cita en la base de datos o en un archivo
        System.out.println("Cita guardada para: " + cita.getNombre());
        System.out.println("Fecha: " + cita.getFecha());
        System.out.println("Hora: " + cita.getHora());
        System.out.println("Descripción: " + cita.getDescripcion());
        System.out.println("Correo: " + cita.getCorreo());

        MailService mailService = new MailService();// objeto de la clase
        String asunto = "Confirmación de cita médica";
        String mensaje = "Estimado paciente, su cita médica ha sido confirmada. Por favor, llegue 10 minutos antes de la hora programada. Gracias.";

        mailService.enviar(cita.getCorreo(), asunto, mensaje); // llamando al metodo enviar de la clase MailService
        mailService = null; // liberando memoria del objeto mailService
        
    }
}
