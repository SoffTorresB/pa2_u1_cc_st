package uce.edu.ec.NegocioDescuentos;

import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent // Crea una instancia dependiente de quien la manda a llamar o inyecta

public class Auditoria {
    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public void registrar(String mensaje) {
        System.out.println("|Identificador de auditoría: " + id + "|" + mensaje);

    }

}
