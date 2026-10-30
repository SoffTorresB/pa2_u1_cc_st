package ec.uce.edu.pa.paquete;

public class Matricula {
    private String estudiante;
    private String materia;
    private double costo;
    private String correo;
    private String telefono;

    public Matricula() {
    }

    public Matricula(String estudiante, String materia, double costo, String correo, String telefono) {
        this.estudiante = estudiante;
        this.materia = materia;
        this.costo = costo;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}