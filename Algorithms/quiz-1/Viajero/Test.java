package Viajero;

import linkedListG.*;

//el primer metdo a ejecutar es viajero.calculargastos, para que los valores que se 
//consultan estén en las propiedades
public class Test {

    public static void main(String[] args) {
        Ropa obj1 = new Ropa(220);
        Ropa obj2 = new Ropa(175);
        Transporte obj3 = new Transporte(60);
        Transporte obj4 = new Transporte(80);
        Comida obj5 = new Comida(45);
        Comida obj6 = new Comida(35);
        Hospedaje obj7 = new Hospedaje(130);
        Hospedaje obj8 = new Hospedaje(95);
        Ropa obj9 = new Ropa(160);
        Ropa obj10 = new Ropa(130);
        Comida obj11 = new Comida(55);
        Transporte obj12 = new Transporte(65);
        Ropa obj13 = new Ropa(95);
        Ropa obj14 = new Ropa(85);
        Transporte obj15 = new Transporte(70);
        Hospedaje obj16 = new Hospedaje(110);
        Hospedaje obj17 = new Hospedaje(125);
        Comida obj18 = new Comida(40);

        Gastos[] gastos = {
                obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12,
                obj13, obj14, obj15, obj16, obj17, obj18
        };

        LinkedList<Gastos> gastosL = new LinkedList<>();

        for (Gastos gasto : gastos) {
            gastosL.addLast(gasto);
        }

        Viajero v = new Viajero(gastosL);

        v.calcularGastos();
        int cantidadGastosComida = v.getCantidadGastosComida();
        String gastoMayor = v.mayorTipoDeGasto();
        System.out.println("Gastos por concepto de Comida: " + v.getGastosComida());
        System.out.println("Gastos por concepto de Hospedaje: " + v.getGastosHospedaje());
        System.out.println("Gastos por concepto de Transporte: " + v.getGastosTransporte());
        System.out.println("Gastos por concepto de Ropa: " + v.getGastosRopa());

        System.out.println("Cantidad de gastos en Comida: " + cantidadGastosComida);
        System.out.println(gastoMayor);
    }

}
