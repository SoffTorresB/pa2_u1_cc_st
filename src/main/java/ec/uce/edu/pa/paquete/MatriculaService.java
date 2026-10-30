package ec.uce.edu.pa.paquete;

import ec.uce.edu.pa.paquete.interceptor.Auditoria;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatriculaService {

    @Auditoria
    public String realizar(Matricula matricula, String otherParameter) {
        System.out.println("::::::::::::::::::::::::::::: \nRealizando matricula....");
        System.out.println("Matricula realizada para el estudiante: " + matricula.getEstudiante());
        System.out.println("Materia: " + matricula.getMateria());
        System.out.println("Costo: " + matricula.getCosto());
        System.out.println("Correo: " + matricula.getCorreo());
        System.out.println("Telefono: " + matricula.getTelefono());
        System.out.println("Matricula realizada con exito. \n ::::::::::::::::::::::::::::: ");

        return "[MatriculaService] Se ha ejecutado correctamente";
    }

}