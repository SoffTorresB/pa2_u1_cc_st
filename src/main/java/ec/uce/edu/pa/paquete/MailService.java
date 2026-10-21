package ec.uce.edu.pa.paquete;

//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

//@ApplicationScoped //delego el control al contenedor
//@RequestScoped -> solo para aplicaciones web
@Singleton

public class MailService {
    public void enviar(String destinatario, String asunto, String mensaje) {
        System.out.println("Enviando correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con éxito");

    }

}
