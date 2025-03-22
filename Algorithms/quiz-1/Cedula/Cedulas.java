package Cedula;

import Algoritmos.BusquedaBinariaList;
import Algoritmos.InsertionSortList;
import linkedListG.*;

// La primera operación debe ser ordenar la lista
public class Cedulas {

    // ======= ATRIBUTO =======
    private LinkedList<Integer> cedulas;

    // ======= CONSTRUCTORES =======
    public Cedulas() {
    }

    public Cedulas(LinkedList<Integer> cedulas) {
        this.cedulas = cedulas;
    }

    // ======= MÉTODO PARA ORDENAR =======
    public void ordenar() {
        this.cedulas = InsertionSortList.insertionSort(cedulas);
    }

    // ======= MÉTODO PARA BUSCAR UN NÚMERO =======
    // La lista debe estar ordenada antes de usar este método
    public int existeNumero() {
        return BusquedaBinariaList.busquedaBinaria(cedulas, 19144473);
    }

    // ======= MÉTODO PARA CONTAR CÉDULAS MAYORES A UN VALOR =======
    public int numerosMayores() {
        int mayores = 0;
        for (int i = 0; i < cedulas.getSize(); i++) {
            if (cedulas.get(i) > 19145954) {
                mayores++;
            }
        }
        return mayores;
    }

    // ======= MÉTODOS GETTERS Y SETTERS =======
    public LinkedList<Integer> getCedulas() {
        return this.cedulas;
    }

    public void setCedulas(LinkedList<Integer> list) {
        this.cedulas = list;
    }
}
