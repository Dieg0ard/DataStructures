package Notas;

import Algoritmos.InsertionSortListObj;
import linkedListG.*;

public class NotasManager {
    // ========================== ATRIBUTOS ==========================
    int aprobados, desaprobados;
    public LinkedList<Nota> NOTAS;
    boolean ordenado;
    int promedio;

    // ========================== CONSTRUCTOR ==========================
    public NotasManager() {
        ordenado = false;
        NOTAS = new LinkedList<>(); // Usamos una lista enlazada en lugar de un arreglo
    }

    // ========================== MÉTODOS PÚBLICOS ==========================
    public void imprimirResumen() {
        ordenar();
        calcularAprobados();
        System.out.println("Nota promedio de la clase: " + getPromedioNotas());

        System.out.println("Nota más alta: " + getNotaMasAlta().getNota()
                + " de " + getNotaMasAlta().getEstudiante());

        System.out.println("Nota más baja: " + getNotaMasBaja().getNota()
                + " de " + getNotaMasBaja().getEstudiante());

        System.out.println("Notas superiores a 18: " + getNotasSuperiores());

        System.out.println("Notas superiores al promedio: " + getNotasSuperioresAlPromedio());

        System.out.println("Porcentaje de aprobados: " + (aprobados * 100) / NOTAS.getSize() + "%");

        System.out.println("Porcentaje de desaprobados: " + (desaprobados * 100) / NOTAS.getSize() + "%");
    }

    // ========================== MÉTODO DE ORDENAMIENTO ==========================
    public void ordenar() {
        InsertionSortListObj.insertionSortNota(NOTAS);
    }

    // ========================== MÉTODOS DE CONSULTA ==========================
    public Nota getNotaMasAlta() {
        if (!ordenado) {
            ordenar();
        }
        return NOTAS.nodeGetLastValue(); // Retorna la última nota (más alta)
    }

    public Nota getNotaMasBaja() {
        if (!ordenado) {
            ordenar();
        }
        return NOTAS.nodeGetFirstValue(); // Retorna la primera nota (más baja)
    }

    public int getPromedioNotas() {
        int suma = 0;
        Node<Nota> currentNode = NOTAS.getFirstNode();
        int count = 0;

        while (currentNode != null) {
            suma += currentNode.getValue().getNota();
            currentNode = currentNode.getNext();
            count++;
        }

        promedio = suma / count;
        return promedio;
    }

    public int getNotasSuperiores() {
        if (NOTAS.getSize() == 0) {
            return 0;
        }
        if (!ordenado) {
            ordenar();
        }
        int notasSuperiores = 0;
        Node<Nota> currentNode = NOTAS.getFirstNode();

        while (currentNode != null) {
            if (currentNode.getValue().getNota() >= 18) {
                notasSuperiores++;
            }
            currentNode = currentNode.getNext();
        }

        return notasSuperiores;
    }

    public int getNotasSuperioresAlPromedio() {
        if (NOTAS.getSize() == 0) {
            return 0;
        }
        if (!ordenado) {
            ordenar();
        }
        int notasSuperiores = 0;
        Node<Nota> currentNode = NOTAS.getFirstNode();

        while (currentNode != null) {
            if (currentNode.getValue().getNota() > promedio) {
                notasSuperiores++;
            }
            currentNode = currentNode.getNext();
        }

        return notasSuperiores;
    }

    // ========================== MÉTODOS DE CÁLCULO ==========================
    public void calcularAprobados() {
        int notaParaAprobar = 11;
        int indice = 0;

        Node<Nota> currentNode = NOTAS.getFirstNode();
        while (currentNode != null) {
            if (currentNode.getValue().getNota() >= notaParaAprobar) {
                break;
            }
            indice++;
            currentNode = currentNode.getNext();
        }

        desaprobados = indice;
        aprobados = NOTAS.getSize() - indice;
    }

}
