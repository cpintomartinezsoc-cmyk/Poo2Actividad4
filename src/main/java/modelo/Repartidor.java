package modelo;

import java.util.ArrayList;

public class Repartidor implements Runnable {

    private String nombre;
    private ArrayList<Pedido> pedidos;

    public Repartidor(
            String nombre,
            ArrayList<Pedido> pedidos) {

        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    @Override
    public void run() {

        System.out.println(
                nombre + " comienza sus entregas."
        );

        for (Pedido pedido : pedidos) {

            pedido.cambiarEstado(
                    Estadopedido.EN_PREPARACION
            );

            pedido.asignarRepartidor(nombre);

            System.out.println(
                    nombre +
                            " entrega pedido " +
                            pedido.getNumeroPedido() +
                            " a " +
                            pedido.getCliente() +
                            "."
            );

            int tiempoEntrega =
                    (int) (Math.random() * 3) + 1;

            try {

                Thread.sleep(
                        tiempoEntrega * 1000L
                );

                pedido.cambiarEstado(
                        Estadopedido.LISTO
                );

            } catch (InterruptedException e) {

                pedido.cambiarEstado(
                        Estadopedido.CANCELADO
                );

                Thread.currentThread().interrupt();

                System.out.println(
                        "Entrega interrumpida."
                );

                return;
            }
        }

        System.out.println(
                nombre + " termino sus entregas."
        );
    }
}