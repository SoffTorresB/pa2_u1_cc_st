package ec.uce.edu.pa.paquete.Interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@SMS
@Interceptor
@Priority(2010)
public class SMSInterceptor {
    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object resul = context.proceed();
        System.out.println("[SMS] Enviando notificación por SMS...");

        return resul;
    }
}
