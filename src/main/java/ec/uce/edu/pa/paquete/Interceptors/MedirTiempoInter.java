package ec.uce.edu.pa.paquete.Interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(2030)

public class MedirTiempoInter {
    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        long init = System.currentTimeMillis();
        try {
            return context.proceed(); // Continúa hacia la siguiente capa (Auditoría)
        } finally {
            long fin = System.currentTimeMillis();
            System.out.println("Interceptor: El metodo demoró => " + (fin - init) + " ms");
        }
    }
}