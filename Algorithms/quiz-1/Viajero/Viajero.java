package Viajero;

import linkedListG.*;

//El primer metodo que se debe ejecutar es calcularGastos, para que el resto de propiedades
//se actualizen y se realize correctamenre las otras operaciones

//The firs method that must be executed is "calcularGastos" for update the another properties in the 
// "Viajer" class, so, we will be able to use correctly the another operations

public class Viajero {
    private int gastosComida;
    private int gastosHospedaje;
    private int gastosTransporte;
    private int gastosRopa;
    private int cantidadGastosComida;

    LinkedList<Gastos> gastos = new LinkedList<>();

    public Viajero() {

    }

    public Viajero(LinkedList<Gastos> list) {
        this.gastos = list;
    }

    public void calcularGastos() {
        int comida = 0;
        int transporte = 0;
        int hospedaje = 0;
        int ropa = 0;
        this.cantidadGastosComida = 0;
        for (int i = 0; i < gastos.getSize(); i++) {
            if (gastos.get(i) instanceof Transporte) {
                transporte += gastos.get(i).getValor();
            }
            if (gastos.get(i) instanceof Hospedaje) {
                hospedaje += gastos.get(i).getValor();
            }
            if (gastos.get(i) instanceof Comida) {
                comida += gastos.get(i).getValor();
                this.cantidadGastosComida++;
            }
            if (gastos.get(i) instanceof Ropa) {
                ropa += gastos.get(i).getValor();
            }
        }
        this.gastosComida = comida;
        this.gastosRopa = ropa;
        this.gastosHospedaje = hospedaje;
        this.gastosTransporte = transporte;

    }

    public int getCantidadGastosComida() {
        return this.cantidadGastosComida;
    }

    public String mayorTipoDeGasto() {
        LinkedList<Integer> gastosTipo = new LinkedList<>();
        gastosTipo.addBeginning(this.gastosComida);
        gastosTipo.addBeginning(this.gastosHospedaje);
        gastosTipo.addBeginning(this.gastosTransporte);
        gastosTipo.addBeginning(this.gastosRopa);

        int mayor = 0;
        for (int i = 0; i < gastosTipo.getSize(); i++) {
            if (gastosTipo.get(i) > mayor) {
                mayor = gastosTipo.get(i);
            }
        }
        if (mayor == gastosComida) {
            return "El tipo de gasto en el que más se invirtió durante el viaje fue COMIDA";
        }
        if (mayor == gastosHospedaje) {
            return "El tipo de gasto en el que más se invirtió durante el viaje fue HOSPEDAJE";
        }
        if (mayor == gastosTransporte) {
            return "El tipo de gasto en el que más se invirtió durante el viaje fue TRANSPORTE";
        }
        if (mayor == gastosRopa) {
            return "El tipo de gasto en el que más se invirtió durante el viaje fue ROPA";
        }
        return "";
    }

    // ========================== GETTERS ==========================

    public int getGastosComida() {
        return this.gastosComida;
    }

    public int getGastosHospedaje() {
        return this.gastosHospedaje;
    }

    public int getGastosTransporte() {
        return this.gastosTransporte;
    }

    public int getGastosRopa() {
        return this.gastosRopa;
    }

    // ========================== SETTERS ==========================
    public void setGastosComida(int gastosComida) {
        this.gastosComida = gastosComida;
    }

    public void setGastosHospedaje(int gastosHospedaje) {
        this.gastosHospedaje = gastosHospedaje;
    }

    public void setGastosTransporte(int gastosTransporte) {
        this.gastosTransporte = gastosTransporte;
    }

    public void setGastosRopa(int gastosRopa) {
        this.gastosRopa = gastosRopa;
    }

}
