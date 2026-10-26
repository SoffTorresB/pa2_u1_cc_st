package uce.edu.ec.NegocioDescuentos;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
@Named("regular")
public class DescuentoRegular implements CalculadoraDescuento {
//Generar Identificadores UUID para observar creacion y reutilizacion de instancias
//Se define un atributo y se agrega un metodo getter para obtener el valor del atributo id para que luego VentaService pueda acceder a este valor y mostrarlo en la salida de la consola.


    private final String id = UUID.randomUUID().toString();
    public String getId(){
        return id;
    }

  @Override
  public double calcular(double monto) {
    return monto * 0.05; // descuento del 5%
  } 



}
