package modelo;

import interfaz.Cancelable;
import interfaz.Despachable;
import interfaz.Rastreable;

import java.util.ArrayList;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {

    protected int numeroPedido;
    protected String cliente;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String repartidor;

    protected boolean reservado;
    protected boolean despachado;
    protected boolean cancelado;

    protected volatile Estadopedido estado;

    protected static ArrayList<Pedido> historial = new ArrayList<>();

    public Pedido(int numeroPedido, String cliente, String direccionEntrega, double distanciaKm) {

        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;

        this.repartidor = "Sin asignar";
        this.reservado = false;
        this.despachado = false;
        this.cancelado = false;

        this.estado = Estadopedido.PENDIENTE;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public Estadopedido getEstado() {
        return estado;
    }

    public synchronized void cambiarEstado(Estadopedido nuevoEstado) {

        this.estado = nuevoEstado;

    }

    public abstract void asignarRepartidor();

    public abstract int calcularTiempoEntrega();

    public void asignarRepartidor(String nombre) {

        repartidor = nombre;

    }

    public void reservarPedido() {

        reservado = true;

        System.out.println(
                "Pedido " + numeroPedido + " reservado."
        );
    }

    @Override
    public void despachar() {

        if (cancelado) {

            System.out.println(
                    "No se puede despachar un pedido cancelado."
            );

        } else {

            despachado = true;
            estado = Estadopedido.EN_PREPARACION;

            historial.add(this);

            System.out.println(
                    "Pedido " + numeroPedido + " despachado."
            );
        }
    }

    @Override
    public void cancelar() {

        if (despachado) {

            System.out.println(
                    "No se puede cancelar un pedido despachado."
            );

        } else {

            cancelado = true;
            estado = Estadopedido.CANCELADO;

            System.out.println(
                    "Pedido " + numeroPedido + " cancelado."
            );
        }
    }

    @Override
    public void verHistorial() {

        System.out.println("\n=== HISTORIAL ===");

        if (historial.isEmpty()) {

            System.out.println(
                    "No existen entregas."
            );

        } else {

            for (Pedido pedido : historial) {

                System.out.println(
                        "Pedido: " + pedido.numeroPedido
                );

                System.out.println(
                        "Cliente: " + pedido.cliente
                );

                System.out.println(
                        "Repartidor: " + pedido.repartidor
                );
            }
        }
    }

    public void mostrarResumen() {

        System.out.println(
                "Pedido: " + numeroPedido
        );

        System.out.println(
                "Cliente: " + cliente
        );

        System.out.println(
                "Direccion: " + direccionEntrega
        );

        System.out.println(
                "Distancia: " + distanciaKm + " km"
        );

        System.out.println(
                "Repartidor: " + repartidor
        );

        System.out.println(
                "Estado: " + estado
        );
    }
}