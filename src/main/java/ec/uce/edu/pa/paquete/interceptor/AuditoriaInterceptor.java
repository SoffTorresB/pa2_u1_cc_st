package ec.uce.edu.pa.paquete.interceptor;

import java.lang.reflect.Parameter;

import ec.uce.edu.pa.paquete.AuditoriaService;
import ec.uce.edu.pa.paquete.Matricula;

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

        String methodName = context.getMethod().getName();
        System.out.println("[Auditoria]-> Nombre del metodo: " + methodName);
        System.out.println("[Auditoria] -> Ejecutacion de lo que haga el interceptor");
        
        Parameter[] parametros = context.getMethod().getParameters();
        for (Parameter p : parametros) {
            System.out.println("Parametros: " + p.getName());
        }
        
        Object[] valores = context.getParameters();
        Matricula matricula = (Matricula) valores[0];
        String estudiante = matricula.getEstudiante();
        double costo = matricula.getCosto();
        String correo = matricula.getCorreo();
        
        this.auditoriaService.guardarEnLaBAse(estudiante, costo, correo);
        
        Object resultado = context.proceed();

        System.out.println("[Auditoria]Retorno :\"" + resultado.toString() + "\"");
        System.out.println("[Auditoria] -> Mensaje posterior a la ejecucion del metodo");
        return resultado;
    }
}