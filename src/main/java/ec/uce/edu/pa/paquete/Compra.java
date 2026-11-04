package ec.uce.edu.pa.paquete;

public class Compra {
    private String cliente;
    private String producto;
    private String correo;
    private double total;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Compra() {

    }

    public Compra(String cliente, String producto, String correo, double total, String telefono) {
        this.cliente = cliente;
        this.producto = producto;
        this.correo = correo;
        this.total = total;
        this.telefono = telefono;
    }

}