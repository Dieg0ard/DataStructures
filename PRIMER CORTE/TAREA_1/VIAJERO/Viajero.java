import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Viajero {
    private List<Gasto> gastos;

    public Viajero() {
        this.gastos = new ArrayList<>();
    }

    public void agregarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public Map<TipoGasto, Double> calcularGastosPorTipo() {
        Map<TipoGasto, Double> totales = new EnumMap<>(TipoGasto.class);
        for (TipoGasto tipo : TipoGasto.values()) {
            totales.put(tipo, 0.0);
        }
        for (Gasto gasto : gastos) {
            totales.put(gasto.getTipo(), totales.get(gasto.getTipo()) + gasto.getMonto());
        }
        return totales;
    }

    public int contarGastosEnComida() {
        int contador = 0;
        for (Gasto gasto : gastos) {
            if (gasto.getTipo() == TipoGasto.COMIDA) {
                contador++;
            }
        }
        return contador;
    }

    public TipoGasto tipoDeGastoMasAlto() {
        Map<TipoGasto, Double> totales = calcularGastosPorTipo();
        TipoGasto maxTipo = null;
        double maxGasto = 0;

        for (Map.Entry<TipoGasto, Double> entry : totales.entrySet()) {
            if (entry.getValue() > maxGasto) {
                maxGasto = entry.getValue();
                maxTipo = entry.getKey();
            }
        }
        return maxTipo;
    }

    public void imprimirResumen() {
        System.out.println("Gastos totales por tipo:");
        for (Map.Entry<TipoGasto, Double> entry : calcularGastosPorTipo().entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        System.out.println("\nCantidad de gastos en comida: " + contarGastosEnComida());
        System.out.println("Tipo de gasto con mayor inversión: " + tipoDeGastoMasAlto());
    }
}
