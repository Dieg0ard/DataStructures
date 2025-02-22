import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class Viajero {
    private ArrayList<Gasto> gastos;
    private EnumMap<TipoGasto, Double> gastosTotales;

    public Viajero() {
        this.gastos = new ArrayList<>();
        this.gastosTotales = new EnumMap<>(TipoGasto.class);

        // Inicializar todos los tipos de gasto en 0.0
        for (TipoGasto tipo : TipoGasto.values()) {
            gastosTotales.put(tipo, 0.0);
        }
    }

    public void agregarGasto(TipoGasto tipo, double monto) {
        gastos.add(new Gasto(tipo, monto));
        gastosTotales.put(tipo, gastosTotales.get(tipo) + monto);
    }

    public EnumMap<TipoGasto, Double> calcularGastosTotales() {
        return gastosTotales;
    }

    public int contarGastosComida() {
        int contador = 0;
        for (Gasto gasto : gastos) {
            if (gasto.getTipo() == TipoGasto.COMIDA) {
                contador++;
            }
        }
        return contador;
    }

    public TipoGasto tipoGastoMasAlto() {
        TipoGasto maxTipo = null;
        double maxMonto = 0;

        for (Map.Entry<TipoGasto, Double> entry : gastosTotales.entrySet()) {
            if (entry.getValue() > maxMonto) {
                maxMonto = entry.getValue();
                maxTipo = entry.getKey();
            }
        }
        return maxTipo;
    }
}

