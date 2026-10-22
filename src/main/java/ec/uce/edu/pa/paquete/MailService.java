package ec.uce.edu.pa.paquete;

import jakarta.inject.Named;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

//@ApplicationScoped //delego el control al contenedor
//@RequestScoped -> solo para aplicaciones web
@Singleton
@Named("mail")
public class MailService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con éxito");
        System.out.println("Fin de envio del correo");

    }

}
