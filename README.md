<img width="488" height="157" alt="image" src="https://github.com/user-attachments/assets/715c6045-1706-4f3b-8149-86fcf6acf7e8" />

# 🧵 Actividad Formativa – Ejecutando tareas en paralelo con hilos en Java 👤

---

## 👨‍💻 Datos del estudiante

**Nombre:** Camilo Pinto

**Carrera:** Analista Programador

**Asignatura:** Desarrollo Orientado a Objetos II

**Caso:** SpeedFast

---

## 📌 Descripción

En esta actividad se continúa desarrollando el sistema de pedidos de la empresa **SpeedFast**, incorporando la ejecución de tareas en paralelo mediante **hilos en Java**.

El proyecto integra los contenidos trabajados anteriormente, utilizando:

* **Clases abstractas**
* **Herencia**
* **Polimorfismo**
* **Interfaces**
* **Runnable**
* **Thread**
* **Thread.sleep()**
* **ArrayList**
* **ExecutorService**
* Ejecución de tareas en paralelo

---

## 📂 Estructura del proyecto

```text
src/main/java
│
├── app
│   └── Main.java
│
├── interfaz
│   ├── Cancelable.java
│   ├── Despachable.java
│   └── Rastreable.java
│
├── modelo
│   ├── Estadopedido.java
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoEncomienda.java
│   ├── PedidoExpress.java
│   └── Repartidor.java
│
└── tareas
    └── PrepararPedido.java
```

---

## 🧱 Clase abstracta `Pedido`

La clase **Pedido** corresponde a la clase abstracta principal del sistema.

Contiene información común para todos los tipos de pedidos, como:

* Número de pedido
* Cliente
* Dirección de entrega
* Distancia en kilómetros
* Repartidor
* Estado del pedido

Además, define métodos abstractos que son implementados por las clases hijas:

```java
public abstract void asignarRepartidor();

public abstract int calcularTiempoEntrega();
```

También implementa las interfaces:

```java
Cancelable
Despachable
Rastreable
```

---

## 🍔 `PedidoComida`

Representa un pedido proveniente de un restaurante.

Hereda de:

```java
Pedido
```

Implementa sus propios métodos para:

* Asignar repartidor
* Calcular tiempo de entrega
* Mostrar información específica del pedido

---

## 📦 `PedidoEncomienda`

Representa una encomienda que debe ser enviada a un destino determinado.

Hereda de:

```java
Pedido
```

Cuenta con información adicional relacionada con el **destino de la encomienda**.

---

## 🛒 `PedidoExpress`

Representa una compra que debe ser entregada mediante el servicio express.

Hereda de:

```java
Pedido
```

Cuenta con información adicional relacionada con el **tipo de compra**.

---

## 🚴 Clase `Repartidor`

La clase **Repartidor** representa a cada trabajador encargado de realizar las entregas.

Cada repartidor posee:

* Nombre
* Lista de pedidos asignados

La clase implementa:

```java
Runnable
```

Esto permite que cada repartidor pueda ejecutarse como una tarea independiente.

```java
public class Repartidor implements Runnable
```

El método `run()` recorre los pedidos asignados y procesa cada entrega de forma secuencial.

---

## 🧵 `Runnable`

La interfaz **Runnable** permite definir una tarea que puede ser ejecutada por un hilo.

En este proyecto:

```java
Repartidor implements Runnable
```

Por lo tanto, cada repartidor puede ser enviado al sistema de ejecución para trabajar de manera independiente.

---

## ⏱️ `Thread.sleep()`

Para simular el tiempo que demora cada entrega se utiliza:

```java
Thread.sleep()
```

El tiempo utilizado es generado de manera aleatoria, permitiendo observar que los repartidores trabajan simultáneamente.

Por ejemplo:

```java
int tiempoEntrega = (int) (Math.random() * 3) + 1;

Thread.sleep(tiempoEntrega * 1000L);
```

---

## ⚙️ `ExecutorService`

Para ejecutar los repartidores en paralelo se utiliza:

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
```

Luego se envían los tres repartidores:

```java
executor.submit(carlos);
executor.submit(maria);
executor.submit(pedro);
```

Esto permite que **Carlos, María y Pedro puedan realizar sus entregas al mismo tiempo**.

Finalmente se utiliza:

```java
executor.shutdown();
```

para indicar que no se agregarán nuevas tareas.

---


## 🧠 Conceptos aplicados

### **Abstracción**

Se utiliza la clase abstracta:

```java
Pedido
```

para definir las características y comportamientos comunes de los distintos tipos de pedidos.

### **Herencia**

Las clases:

```text
PedidoComida
PedidoEncomienda
PedidoExpress
```

heredan de:

```text
Pedido
```

### **Polimorfismo**

Los diferentes tipos de pedidos son almacenados utilizando el tipo:

```java
Pedido
```

pero cada objeto ejecuta su propia implementación de los métodos sobrescritos.

### **Interfaces**

Se utilizan las interfaces:

```text
Cancelable
Despachable
Rastreable
```

para definir comportamientos adicionales para los pedidos.



---

## ▶️ Ejecución

Para ejecutar el proyecto:

1. Abrir el proyecto en **IntelliJ IDEA**.
2. Ubicar la clase:

```text
Main.java
```

3. Ejecutar el método:

```java
public static void main(String[] args)
```

4. Observar en la consola la ejecución simultánea de los tres repartidores.

---

## 📚 Contenidos utilizados

| Contenido       | Aplicación                                |
| --------------- | ----------------------------------------- |
| Clase abstracta | `Pedido`                                  |
| Herencia        | Clases de pedidos                         |
| Polimorfismo    | Referencias de tipo `Pedido`              |
| Interfaces      | `Cancelable`, `Despachable`, `Rastreable` |
| ArrayList       | Lista de pedidos                          |
| Runnable        | `Repartidor`                              |
| Thread.sleep()  | Simulación de entregas                    |
| ExecutorService | Ejecución de repartidores                 |
| Hilos           | Trabajo paralelo                          |

---

## 📁 Repositorio

**Repositorio GitHub:**

`Poo2Semana4`

**Entrega:** 07/09/2026


