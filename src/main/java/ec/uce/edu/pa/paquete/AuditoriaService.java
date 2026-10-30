package ec.uce.edu.pa.paquete;

import java.time.LocalDateTime;

import jakarta.inject.Singleton;

@Singleton
public class AuditoriaService {

    public void guardarEnLaBAse(String estudiante, double costo, String correo) {

        System.out.printf(
                "-> Guardando en la  base de datos la auditoria:%n->Estudiante: %s%n->Costo: %.2f%n->Correo: %s%n",
                estudiante, costo, correo);

        System.out.println("Con fecha y hora:" + LocalDateTime.now().toString());

    }
}