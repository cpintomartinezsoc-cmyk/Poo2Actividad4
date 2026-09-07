package app;

import modelo.Pedido;
import modelo.PedidoComida;
import modelo.PedidoEncomienda;
import modelo.PedidoExpress;
import modelo.Repartidor;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SPEEDFAST ===\n");

        Pedido pedido1 = new PedidoComida(
                1,
                "Fernando",
                "Av. Vicente Perez Rosales 120",
                3.0,
                "Cafe Puerto Varas"
        );

        Pedido pedido2 = new PedidoExpress(
                2,
                "Vanessa",
                "Av. Gramado 450",
                2.0,
                "Electronica"
        );

        Pedido pedido3 = new PedidoEncomienda(
                3,
                "Francisco",
                "Camino a Ensenada 800",
                8.0,
                "Ensenada"
        );


        Pedido pedido4 = new PedidoComida(
                4,
                "Jorge",
                "Calle San Francisco 230",
                2.5,
                "Restaurante Puerto Varas"
        );

        Pedido pedido5 = new PedidoExpress(
                5,
                "Juan",
                "Av. Colon 600",
                3.0,
                "Ropa"
        );

        Pedido pedido6 = new PedidoEncomienda(
                6,
                "Agustin",
                "Camino a Nueva Braunau 300",
                6.0,
                "Nueva Braunau"
        );


        Pedido pedido7 = new PedidoComida(
                7,
                "Maria",
                "Av. Costanera 100",
                2.0,
                "Comida"
        );

        Pedido pedido8 = new PedidoExpress(
                8,
                "Claudio",
                "Calle Del Salvador 350",
                2.5,
                "Tecnologia"
        );

        Pedido pedido9 = new PedidoEncomienda(
                9,
                "Nelson",
                "Camino a Frutillar 500",
                12.0,
                "Frutillar"
        );


        ArrayList<Pedido> pedidosCarlos =
                new ArrayList<>();

        pedidosCarlos.add(pedido1);
        pedidosCarlos.add(pedido2);
        pedidosCarlos.add(pedido3);


        ArrayList<Pedido> pedidosMaria =
                new ArrayList<>();

        pedidosMaria.add(pedido4);
        pedidosMaria.add(pedido5);
        pedidosMaria.add(pedido6);


        ArrayList<Pedido> pedidosPedro =
                new ArrayList<>();

        pedidosPedro.add(pedido7);
        pedidosPedro.add(pedido8);
        pedidosPedro.add(pedido9);

        Repartidor carlos =
                new Repartidor(
                        "Carlos",
                        pedidosCarlos
                );

        Repartidor maria =
                new Repartidor(
                        "Maria",
                        pedidosMaria
                );

        Repartidor pedro =
                new Repartidor(
                        "Pedro",
                        pedidosPedro
                );


        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        System.out.println(
                "Comienzan las entregas:\n"
        );

        executor.submit(carlos);
        executor.submit(maria);
        executor.submit(pedro);

        executor.shutdown();

        while (!executor.isTerminated()) {

            try {

                Thread.sleep(500);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        "Simulacion interrumpida."
                );

                break;
            }
        }

        System.out.println(
                "\n=== ENTREGAS FINALIZADAS ==="
        );
    }
}