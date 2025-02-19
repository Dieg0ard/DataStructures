public class Main {
    public static void main(String[] args) {
        Viajero viajero = new Viajero();

        // Agregamos 18 gastos simulados
        viajero.agregarGasto(TipoGasto.COMIDA, 25.0);
        viajero.agregarGasto(TipoGasto.TRANSPORTE, 10.0);
        viajero.agregarGasto(TipoGasto.HOSPEDAJE, 100.0);
        viajero.agregarGasto(TipoGasto.ROPA, 50.0);
        viajero.agregarGasto(TipoGasto.COMIDA, 30.0);
        viajero.agregarGasto(TipoGasto.TRANSPORTE, 15.0);
        viajero.agregarGasto(TipoGasto.HOSPEDAJE, 120.0);
        viajero.agregarGasto(TipoGasto.COMIDA, 40.0);
        viajero.agregarGasto(TipoGasto.ROPA, 60.0);
        viajero.agregarGasto(TipoGasto.TRANSPORTE, 20.0);
        viajero.agregarGasto(TipoGasto.HOSPEDAJE, 80.0);
        viajero.agregarGasto(TipoGasto.COMIDA, 35.0);
        viajero.agregarGasto(TipoGasto.ROPA, 70.0);
        viajero.agregarGasto(TipoGasto.TRANSPORTE, 25.0);
        viajero.agregarGasto(TipoGasto.HOSPEDAJE, 110.0);
        viajero.agregarGasto(TipoGasto.COMIDA, 50.0);
        viajero.agregarGasto(TipoGasto.ROPA, 80.0);
        viajero.agregarGasto(TipoGasto.TRANSPORTE, 30.0);

        // Mostramos los gastos totales por tipo
        System.out.println("Gastos totales por tipo:");
        for (var entry : viajero.calcularGastosTotales().entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        // Mostramos la cantidad de gastos en comida
        System.out.println("\nCantidad de gastos en comida: " + viajero.contarGastosComida());

        // Mostramos el tipo de gasto más alto
        System.out.println("\nTipo de gasto en el que más invirtió dinero: " + viajero.tipoGastoMasAlto());
    }
}

