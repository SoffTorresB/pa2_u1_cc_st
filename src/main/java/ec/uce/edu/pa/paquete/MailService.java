package ec.uce.edu.pa.paquete;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

//ÁMBITOS Y CONTEXTOS
//@ApplicationScoped //delego el control al contenedor//Su ámbito es durante toda la aplicacion, es decir se crea un objeto una sola instancia de la clase y se comparte entre todos los componentes que la utilizan
//@RequestScoped -> solo para aplicaciones web//Su ambito es en aplicaciones web durante el request o peticion http
//@SessionScoped //Su ambito es en aplicaciones web durante la sesion
//@Singleton//Su ámbito es durante toda la aplicacion es decir se crea una sola instancia de la clase y se comparte entre todos  los componentes que la utilizan
@Dependent //Su ambito es durante la inyeccion de dependencias es decir se crea una instancia y se comparte durante todos los componentes que la utilizan durante la inyeccion de dependencias//Cada vez que se inyecte se creará un nuevo objeto

//@Singleton 
@Named("mail")
public class MailService implements Notificacion {
    private Integer cantidad = 0;
    private String nombre;

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con éxito");
        System.out.println("Fin de envio del correo");

    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

        public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


   


  
}
