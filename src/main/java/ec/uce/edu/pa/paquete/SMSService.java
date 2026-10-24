package ec.uce.edu.pa.paquete;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton 
@Named("sms")

public class SMSService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando SMS a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("SMS enviado con éxito");
        System.out.println("Fin de envio del SMS");

    }

    @Override
    public Integer getCantidad() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCantidad(Integer cantidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    @Override
    public void setNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

    }


