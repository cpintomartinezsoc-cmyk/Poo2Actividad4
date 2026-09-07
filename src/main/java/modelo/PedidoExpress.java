package modelo;

public class PedidoExpress extends Pedido {

    private String tipoCompra;

    public PedidoExpress(
            int numeroPedido,
            String cliente,
            String direccionEntrega,
            double distanciaKm,
            String tipoCompra) {

        super(
                numeroPedido,
                cliente,
                direccionEntrega,
                distanciaKm
        );

        this.tipoCompra = tipoCompra;
    }

    @Override
    public void asignarRepartidor() {

        repartidor = "Pedro";

    }

    @Override
    public int calcularTiempoEntrega() {

        return 20;

    }

    @Override
    public void mostrarResumen() {

        System.out.println("\n=== PEDIDO EXPRESS ===");

        super.mostrarResumen();

        System.out.println(
                "Tipo de compra: " + tipoCompra
        );

        System.out.println(
                "Tiempo estimado: " +
                        calcularTiempoEntrega() +
                        " minutos"
        );
    }
}