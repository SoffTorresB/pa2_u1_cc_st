package ec.uce.edu.pa.paquete.Interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Mail
@Interceptor 
@Priority (2000)
public class MailInterceptor {
    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {
        Object resul = context.proceed();
        
        System.out.println("[Mail] Enviando notificación por correo electrónico...");
        
        return resul;

}}
