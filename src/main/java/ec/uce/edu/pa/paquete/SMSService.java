package ec.uce.edu.pa.paquete;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
@Named("sms")
public class SMSService implements Notificacion {
    private Integer cant = 0;
    private String name;

    @Override
    public void enviar(String destino, String msj) {
        System.out.println("Enviar SMS a " + destino);
        System.out.println("Mensaje:" + msj);
        System.out.println("SMS enviado con exito. \n Fin del envio del SMS");
        System.out.println("-------------------------------------------");
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}