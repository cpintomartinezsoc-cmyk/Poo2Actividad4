package modelo;

public class PedidoEncomienda extends Pedido {

    private String destino;

    public PedidoEncomienda(
            int numeroPedido,
            String cliente,
            String direccionEntrega,
            double distanciaKm,
            String destino) {

        super(
                numeroPedido,
                cliente,
                direccionEntrega,
                distanciaKm
        );

        this.destino = destino;
    }

    @Override
    public void asignarRepartidor() {

        repartidor = "Maria";

    }

    @Override
    public int calcularTiempoEntrega() {

        return 60;

    }

    @Override
    public void mostrarResumen() {

        System.out.println("\n=== PEDIDO DE ENCOMIENDA ===");

        super.mostrarResumen();

        System.out.println(
                "Destino: " + destino
        );

        System.out.println(
                "Tiempo estimado: " +
                        calcularTiempoEntrega() +
                        " minutos"
        );
    }
}