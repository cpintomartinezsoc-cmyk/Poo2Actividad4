package tareas;

import modelo.Estadopedido;
import modelo.Pedido;

public class PrepararPedido implements Runnable {

    private final Pedido pedido;

    public PrepararPedido(Pedido pedido) {

        this.pedido = pedido;

    }

    @Override
    public void run() {

        pedido.cambiarEstado(
                Estadopedido.EN_PREPARACION
        );

        System.out.println(
                "Preparando pedido " +
                        pedido.getNumeroPedido()
        );

        try {

            Thread.sleep(
                    pedido.calcularTiempoEntrega() * 1000L
            );

            pedido.cambiarEstado(
                    Estadopedido.LISTO
            );

            System.out.println(
                    "Pedido " +
                            pedido.getNumeroPedido() +
                            " listo."
            );

        } catch (InterruptedException e) {

            pedido.cambiarEstado(
                    Estadopedido.CANCELADO
            );

            Thread.currentThread().interrupt();
        }
    }
}