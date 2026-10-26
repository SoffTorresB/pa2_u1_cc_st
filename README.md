# Programación Avanzada 2
**UNIDAD 1**

**Nombre:** Sofía Torres Batallas

**Fecha de entrega:** 26/10/2026
## TAREA 3: Simulador de descuentos con Quarkus
## 1. Descripción del Problema

El proyecto implementa un simulador de ventas y cálculo de descuentos por consola para una tienda comercial. Las políticas de descuento se definen según la clasificación del cliente:
* **Cliente REGULAR:** 5% de descuento sobre el monto de venta.
* **Cliente VIP:** 15% de descuento sobre el monto de venta.

La solución prescinde totalmente del uso de la palabra reservada `new` para instanciar la lógica de negocio, delegando el ciclo de vida, la inversión de control y la resolución de dependencias al contenedor CDI de Quarkus (**ArC**).

---

## 2. Estructura y Requerimientos Técnicos

El sistema cumple con todos los requerimientos técnicos solicitados:

* **RT01 (Inversión de Control - IoC):** La instanciación y gestión de los componentes de negocio está completamente delegada al contenedor CDI ArC.
* **RT02 (Inyección de Dependencias - DI):** `VentaService` implementa tanto inyección por **atributo** (`@Inject`) para `DescuentoVIP` y `Auditoria`, como inyección por **constructor** (`@Inject`) para `DescuentoRegular`.
* **RT03 (Interfaces e implementaciones):** Se define la interfaz `CalculadoraDescuento` con el método `double calcular(double monto);`, implementada por `DescuentoRegular` (5%) y `DescuentoVIP` (15%).
* **RT04 (Qualifiers):** Se utilizan calificadores `@Named("regular")` y `@Named("VIP")` para desambiguar la interfaz `CalculadoraDescuento` en los puntos de inyección.
* **RT05 y RT06 (Scopes y Ciclo de vida):** 
  * `@ApplicationScoped` en `VentaService`, `DescuentoRegular` y `DescuentoVIP`.
  * `@Dependent` en `Auditoria`.
  * Generación de identificadores `UUID` en cada bean para auditar la creación y reutilización de instancias en memoria.
* **RT07 (Ejecución por consola):** Se inicia Quarkus mediante `QuarkusApplication` desde `Main`, ejecutando en secuencia las 4 ventas de prueba sin menús interactivos.

---
## 3. Preguntas de análisis
**1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?**
- Inversión de Control (IoC): Se evidencia en la delegación total del control de instanciación y ciclo de vida de los componentes al contenedor ArC de Quarkus. En lugar de que el flujo de la aplicación cree los objetos con la palabra clave new, el contenedor toma el control, escanea las anotaciones contextuales (@ApplicationScoped, @Dependent) y administra los beans entre bastidores.

- Inyección de Dependencias (DI): Es el mecanismo técnico específico mediante el cual el contenedor suministra las referencias necesarias a cada clase. Se aplica puntualmente en:

    - Inyección por atributo (@Inject) en VentaService para obtener la instancia de Auditoria y de DescuentoVIP.

    - Inyección por constructor (@Inject) en VentaService para recibir la implementación DescuentoRegular.

    - Inyección de VentaService dentro de la clase principal Main.

**2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?**
- Función: Actúan como metadatos discriminadores que permiten al contenedor CDI identificar y enlazar la implementación concreta adecuada cuando coexisten múltiples clases que implementan un mismo contrato o interfaz.

- Necesidad: En este proyecto, tanto DescuentoRegular como DescuentoVIP implementan CalculadoraDescuento. Si no se utilizaran calificadores como @Named("regular") y @Named("VIP"), el contenedor CDI no tendría criterio para decidir qué implementación suministrar en los puntos de inyección, lo que provocaría un fallo de resolución ambigua (AmbiguousResolutionException) en tiempo de inicio.

**3. ¿Cuál es la diferencia entre @ApplicationScoped y @Dependent?**
- @ApplicationScoped: Define un alcance global a nivel de aplicación (Singleton contextual). El contenedor ArC crea una única instancia del componente que es compartida y reutilizada por todos los clientes a través de un proxy cliente durante toda la vida útil de la aplicación.

- @Dependent: Es el alcance por defecto de CDI. No utiliza proxy ni crea una instancia compartida; su ciclo de vida está estrictamente atado al componente en el que es inyectado. La instancia dependiente se crea al momento de instanciarse el bean contenedor y se destruye cuando este último es destruido.


**4. ¿Por qué las instancias @ApplicationScoped pueden reutilizarse entre varias ventas?**

Las instancias anotadas con @ApplicationScoped pueden reutilizarse porque el contenedor ArC mantiene una referencia persistente y única en memoria. Al ser componentes diseñados sin estado mutable dependiente de una transacción particular (stateless), procesan peticiones sucesivas sin interferencias entre ventas. En la consola se comprueba que el identificador UUID de VentaService permanece inalterado (76437621-1b0e-4820-a8ae-0f7955611dae) a lo largo de las 4 operaciones ejecutadas.

**5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de CalculadoraDescuento?**

Si se remueve el calificador de un punto de inyección (por ejemplo, declarando @Inject private CalculadoraDescuento calculadora;), Quarkus detectará durante el análisis en tiempo de construcción/arranque que existen dos candidatos válidos (DescuentoRegular y DescuentoVIP) que satisfacen el tipo inyectado. Como resultado, la aplicación no iniciará y arrojará una excepción de ambigüedad (Ambiguous dependency / AmbiguousResolutionException), indicando que no puede resolver qué bean inyectar.