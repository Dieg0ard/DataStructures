public class Gasto {
    private final TipoGasto tipo;
    private final double monto;

    public Gasto(TipoGasto tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    public TipoGasto getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }
}
