public class Main {
    public static void main(String[] args) {
        Viajero viajero = new Viajero();
        viajero.agregarGasto(new Gasto(TipoGasto.COMIDA, 30.5));
        viajero.agregarGasto(new Gasto(TipoGasto.HOSPEDAJE, 200.0));
        viajero.agregarGasto(new Gasto(TipoGasto.TRANSPORTE, 50.0));
        viajero.agregarGasto(new Gasto(TipoGasto.ROPA, 80.0));
        viajero.agregarGasto(new Gasto(TipoGasto.COMIDA, 25.0));
        viajero.agregarGasto(new Gasto(TipoGasto.HOSPEDAJE, 150.0));
        viajero.agregarGasto(new Gasto(TipoGasto.COMIDA, 40.0));
        viajero.agregarGasto(new Gasto(TipoGasto.TRANSPORTE, 30.0));
        viajero.agregarGasto(new Gasto(TipoGasto.ROPA, 90.0));
        viajero.agregarGasto(new Gasto(TipoGasto.COMIDA, 35.0));
        viajero.agregarGasto(new Gasto(TipoGasto.HOSPEDAJE, 220.0));
        viajero.agregarGasto(new Gasto(TipoGasto.TRANSPORTE, 40.0));
        viajero.agregarGasto(new Gasto(TipoGasto.ROPA, 50.0));
        viajero.agregarGasto(new Gasto(TipoGasto.COMIDA, 20.0));
        viajero.agregarGasto(new Gasto(TipoGasto.HOSPEDAJE, 180.0));
        viajero.agregarGasto(new Gasto(TipoGasto.TRANSPORTE, 60.0));
        viajero.agregarGasto(new Gasto(TipoGasto.ROPA, 120.0));
        viajero.agregarGasto(new Gasto(TipoGasto.COMIDA, 45.0));

        // Mostrar resumen
        viajero.imprimirResumen();

        
    }

    
}
