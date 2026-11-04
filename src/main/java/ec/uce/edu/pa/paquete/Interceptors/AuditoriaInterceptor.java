package ec.uce.edu.pa.paquete.Interceptors;


import java.lang.reflect.Parameter;

import ec.uce.edu.pa.paquete.AuditoriaService;
import ec.uce.edu.pa.paquete.Pedido;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor
public class AuditoriaInterceptor {

    @Inject
    private AuditoriaService auditoriaService;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

       
        // Todo lo que está arriba se ejecuta antes de ejecutar el método interceptado
        Object resultado = context.proceed(); // ejecuta el método interceptado
           
        System.out.println("Retorno: " + resultado);


        String nombreMetodo = context.getMethod().getName();
        System.out.println("Auditoria: se está ejecutando el método: " + nombreMetodo);
        System.out.println("Ejecuto todo lo que quiero que haga el interceptor");

        Parameter[] parametros = context.getMethod().getParameters();

        for (Parameter parameter : parametros) {
            System.out.println("Parámetro: " + parameter.getName());

        }

        Object[] valores = context.getParameters();

        Pedido pedido = (Pedido) valores[0];

        String cliente = pedido.getCliente();
        double total = pedido.getTotal();
        String correo = pedido.getCorreo();

        this.auditoriaService.guardarEnLaBase(cliente, total, correo);

        System.out.println("Mensaje luego de que se ejecuta el método interceptado");

        return resultado;

    }

}