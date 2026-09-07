<img width="488" height="157" alt="image" src="https://github.com/user-attachments/assets/715c6045-1706-4f3b-8149-86fcf6acf7e8" />

🧵 Actividad Formativa – Ejecutando tareas en paralelo con hilos en Java 👤

Nombre completo: Camilo Pinto

Carrera: Analista Programador

Asignatura: Desarrollo Orientado a Objetos II

Caso: SpeedFast

📘 Descripción general del sistema

Este proyecto corresponde a una actividad de la asignatura Desarrollo Orientado a Objetos II.

El sistema representa una empresa de reparto a domicilio llamada SpeedFast, incorporando la ejecución de tareas en paralelo mediante hilos en Java.

En esta actividad se continúa trabajando con la estructura desarrollada anteriormente, incorporando principalmente:

Clases abstractas
Herencia
Polimorfismo
Interfaces
Runnable
Thread
Thread.sleep()
ArrayList
ExecutorService
Ejecución de tareas en paralelo

SpeedFast trabaja con tres tipos de pedidos:

Pedido de comida
Pedido de encomienda
Pedido Express

Cada pedido posee información como su cliente, dirección de entrega y distancia.

La actividad incorpora repartidores, quienes reciben una lista de pedidos y realizan sus entregas de forma secuencial.

A su vez, los distintos repartidores se ejecutan en paralelo utilizando un ExecutorService.

🧱 Estructura del proyecto
src/
│
├── app/
│   │
│   └── Main.java
│
├── interfaz/
│   │
│   ├── Despachable.java
│   ├── Cancelable.java
│   └── Rastreable.java
│
├── modelo/
│   │
│   ├── Estadopedido.java
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoEncomienda.java
│   ├── PedidoExpress.java
│   └── Repartidor.java
│
└── tareas/
    │
    └── PrepararPedido.java
📂 Descripción de las clases
📦 Pedido

Clase abstracta que representa un pedido genérico de SpeedFast.

Contiene la información común de los diferentes tipos de pedidos y define métodos que deben ser implementados por sus clases hijas.

Atributos principales
numeroPedido
cliente
direccionEntrega
distanciaKm
repartidor
estado

La clase también contiene el método abstracto:

public abstract int calcularTiempoEntrega();

Este método permite que cada tipo de pedido tenga su propio tiempo estimado de entrega.

Además, Pedido implementa las interfaces:

Despachable
Cancelable
Rastreable
🍔 PedidoComida

Clase que hereda de Pedido mediante:

extends Pedido

Representa pedidos provenientes de restaurantes.

Contiene el atributo:

restaurante

Sobrescribe el método:

calcularTiempoEntrega()

para establecer el tiempo estimado correspondiente a este tipo de pedido.

📦 PedidoEncomienda

Clase que hereda de Pedido.

Representa documentos o paquetes que deben ser entregados a un determinado destino.

Contiene el atributo:

destino

También sobrescribe:

calcularTiempoEntrega()

para establecer su tiempo estimado de entrega.

🛒 PedidoExpress

Clase que hereda de Pedido.

Representa compras realizadas mediante el servicio de Compra Express.

Contiene el atributo:

tipoCompra

Sobrescribe el método:

calcularTiempoEntrega()

para establecer el tiempo correspondiente a este tipo de pedido.

🚚 Repartidor

La clase Repartidor representa a una persona encargada de realizar las entregas de SpeedFast.

Esta clase implementa la interfaz:

Runnable

Esto permite que un repartidor pueda ser ejecutado como una tarea mediante un hilo.

La clase contiene:

nombre
pedidos

Donde pedidos corresponde a una lista de objetos de tipo:

ArrayList<Pedido>

Cada repartidor procesa sus pedidos uno por uno.

Durante la entrega se utiliza:

Thread.sleep()

para simular el tiempo que demora cada entrega.

El tiempo de espera se genera de manera aleatoria para representar una situación de entrega diferente en cada ejecución.

🧵 Runnable

La interfaz Runnable permite definir una tarea que puede ser ejecutada por un hilo.

En este proyecto, la clase:

Repartidor

implementa:

Runnable

y sobrescribe el método:

@Override
public void run()

El método run() contiene las instrucciones que ejecutará cada repartidor.

Por ejemplo:

public void run() {

    for (Pedido pedido : pedidos) {

        // proceso de entrega

    }
}

De esta manera, cada repartidor puede ejecutar su lista de pedidos como una tarea independiente.

⏱️ Thread.sleep()

Durante la simulación se utiliza:

Thread.sleep()

para representar el tiempo que demora una entrega.

El tiempo utilizado es generado aleatoriamente.

Esto permite que las entregas no siempre terminen en el mismo orden.

Por ejemplo, un repartidor puede terminar su primer pedido antes que otro repartidor, aunque ambos hayan comenzado al mismo tiempo.

⚙️ ExecutorService

La ejecución de los repartidores se realiza mediante:

ExecutorService

En Main se crea un grupo de tres hilos utilizando:

ExecutorService executor =
        Executors.newFixedThreadPool(3);

Esto permite ejecutar los tres repartidores en paralelo.

Posteriormente se envían las tareas mediante:

executor.submit(carlos);
executor.submit(maria);
executor.submit(pedro);

Cada objeto Repartidor corresponde a una tarea que será ejecutada por el ExecutorService.

Finalmente, se utiliza:

executor.shutdown();

para indicar que no se agregarán nuevas tareas.

🔌 Interfaces

El proyecto mantiene las interfaces utilizadas en la actividad anterior:

Despachable
Cancelable
Rastreable

Estas interfaces definen comportamientos relacionados con los pedidos.

La clase Pedido implementa las tres interfaces mediante:

implements Despachable, Cancelable, Rastreable
🚚 Despachable

La interfaz Despachable representa el comportamiento relacionado con el despacho de un pedido.

Define el método:

void despachar();

La implementación se realiza mediante:

@Override
public void despachar()
❌ Cancelable

La interfaz Cancelable representa el comportamiento relacionado con la cancelación de un pedido.

Define el método:

void cancelar();

La clase Pedido implementa este comportamiento utilizando:

@Override
public void cancelar()
📍 Rastreable

La interfaz Rastreable representa el comportamiento relacionado con el seguimiento de los pedidos.

Define el método:

void verHistorial();

La clase Pedido implementa este método para mostrar el historial de entregas.

📊 Estado de los pedidos

El proyecto utiliza el enum:

Estadopedido

para representar los diferentes estados de un pedido.

Los estados disponibles son:

PENDIENTE
EN_PREPARACION
LISTO
CANCELADO

Durante la ejecución de los repartidores, el estado puede cambiar.

Por ejemplo:

PENDIENTE
     ↓
EN_PREPARACION
     ↓
LISTO

Si una entrega es interrumpida, puede pasar a:

CANCELADO
🖥️ Main

La clase Main corresponde al punto de inicio del programa.

En ella se crean los diferentes pedidos y se asignan a los repartidores.

Funciones principales
Crear objetos de tipo PedidoComida.
Crear objetos de tipo PedidoEncomienda.
Crear objetos de tipo PedidoExpress.
Utilizar referencias de tipo Pedido.
Crear listas utilizando ArrayList.
Crear tres objetos Repartidor.
Asignar pedidos a cada repartidor.
Crear un ExecutorService.
Ejecutar los repartidores mediante submit().
Simular tiempos de entrega mediante Thread.sleep().
Ejecutar los repartidores en paralelo.
Esperar hasta que todos los repartidores terminen.
🔄 Polimorfismo

El proyecto continúa utilizando polimorfismo mediante referencias de tipo Pedido.

Por ejemplo:

Pedido pedido1 = new PedidoComida(...);

La variable es de tipo:

Pedido

pero el objeto corresponde a:

PedidoComida

Lo mismo ocurre con:

Pedido pedido2 = new PedidoExpress(...);

y:

Pedido pedido3 = new PedidoEncomienda(...);

Esto permite almacenar los diferentes tipos de pedidos dentro de:

ArrayList<Pedido>

Por ejemplo:

ArrayList<Pedido> pedidosCarlos =
        new ArrayList<>();

De esta manera, una misma lista puede trabajar con diferentes tipos de pedidos.

🧵 Ejecución en paralelo

Uno de los principales objetivos de esta actividad es ejecutar las tareas de los repartidores en paralelo.

Se crean tres repartidores:

Carlos
Maria
Pedro

Cada uno posee tres pedidos.

La ejecución se realiza mediante:

executor.submit(carlos);
executor.submit(maria);
executor.submit(pedro);

Los tres repartidores pueden comenzar sus entregas prácticamente al mismo tiempo.

Por ejemplo:

Carlos comienza sus entregas.
Maria comienza sus entregas.
Pedro comienza sus entregas.

Luego cada repartidor continúa procesando sus propios pedidos.

El orden en que aparecen las entregas puede cambiar debido a los tiempos aleatorios utilizados durante la simulación.

📍 Ejemplos de entregas

Los pedidos utilizados en la simulación representan situaciones hipotéticas de Puerto Varas y sus alrededores.

Algunas de las direcciones utilizadas son:

Avenida Vicente Pérez Rosales
Avenida Gramado
Calle San Francisco
Avenida Colón
Avenida Costanera
Camino a Ensenada
Camino a Nueva Braunau
Camino a Frutillar

Estas direcciones se utilizan solamente como datos de ejemplo para representar el funcionamiento del sistema.

▶️ Instrucciones para ejecutar el proyecto
Clonar el repositorio desde GitHub.
Abrir el proyecto en IntelliJ IDEA.
Verificar que las clases se encuentren dentro de sus respectivos paquetes.
Ejecutar la clase:
app.Main
Revisar los resultados mostrados en la consola.
Observar que los tres repartidores comienzan sus tareas.
Observar que cada repartidor procesa sus pedidos.
Comprobar que los tiempos de entrega son diferentes debido a la pausa aleatoria.
Verificar que la simulación finaliza cuando todos los repartidores terminan.
💻 Resultado esperado

Al ejecutar el programa, la consola mostrará una salida similar a:

=== SPEEDFAST ===

Comienzan las entregas:

Carlos comienza sus entregas.
Maria comienza sus entregas.
Pedro comienza sus entregas.

Carlos entrega pedido 1 a Pablo.
Maria entrega pedido 4 a Ana.
Pedro entrega pedido 7 a Diego.

Pedro entrega pedido 8 a Felipe.
Carlos entrega pedido 2 a Camila.
Maria entrega pedido 5 a Sofia.

Carlos entrega pedido 3 a Juan.
Maria entrega pedido 6 a Mateo.
Pedro entrega pedido 9 a Laura.

Carlos termino sus entregas.
Maria termino sus entregas.
Pedro termino sus entregas.

=== ENTREGAS FINALIZADAS ===

El orden puede variar en cada ejecución debido a la ejecución en paralelo y a los tiempos aleatorios.

📚 Conceptos utilizados

Durante esta actividad se integran los conceptos trabajados anteriormente y los nuevos contenidos relacionados con hilos:

Clases abstractas
Herencia
Polimorfismo
Interfaces
ArrayList
Runnable
Thread
Thread.sleep()
ExecutorService
Ejecución de tareas en paralelo
Estados de un pedido

La actividad permite continuar ampliando el sistema SpeedFast, incorporando ahora la ejecución de múltiples repartidores de manera paralela.

🔗 Repositorio GitHub

Repositorio: Poo2Semana4

URL: https://github.com/cpintomartinezsoc-cmyk/Poo2Semana4.git

Fecha de entrega: 07/09/2026
