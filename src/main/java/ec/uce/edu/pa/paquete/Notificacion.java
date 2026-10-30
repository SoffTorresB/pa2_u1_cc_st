package ec.uce.edu.pa.paquete;

public interface Notificacion {
    public void enviar(String destino, String msj);

    void setCant(Integer i);

    Integer getCant();

    String getName();

    void setName(String name);

}