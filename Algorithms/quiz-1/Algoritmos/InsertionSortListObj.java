package Algoritmos;

import Notas.*;
import linkedListG.*;

// El método getNota() debe estar implementado en el tipo de objeto que vamos a ordenar
public class InsertionSortListObj {

    // ======= MÉTODO DE ORDENAMIENTO POR INSERCIÓN PARA OBJETOS NOTA =======
    public static LinkedList<Nota> insertionSortNota(LinkedList<Nota> list) {
        for (int i = 0; i < list.getSize() - 1; i++) {

            // Caso especial: si el segundo elemento es menor que el primero,
            // intercambiarlos
            if (i == 0 && list.get(i + 1).getNota() < list.get(i).getNota()) {
                Nota temp = list.get(i + 1);
                list.getNode(i + 1).setValue(list.get(i));
                list.getNode(i).setValue(temp);
            }

            // Manejo de la parte ordenada y búsqueda de la posición correcta del nuevo
            // elemento
            if (list.get(i + 1).getNota() < list.get(i).getNota()) {

                // Buscar la posición correcta en la parte ordenada
                for (int j = 0; j < i; j++) {

                    // Si el elemento es el más pequeño, mover todos los elementos y agregar al
                    // inicio
                    if (list.get(i + 1).getNota() < list.get(j).getNota()) {
                        Nota temp = list.get(i + 1);
                        for (int k = i + 1; k > 0; k--) {
                            list.getNode(k).setValue(list.get(k - 1));
                        }
                        list.getFirstNode().setValue(temp);
                    }

                    // Si el elemento pertenece en medio de la parte ordenada
                    if (list.get(i + 1).getNota() >= list.get(j).getNota()
                            && list.get(i + 1).getNota() < list.get(j + 1).getNota()) {
                        Nota temp = list.get(i + 1);
                        int posicion = 0;
                        for (int k = i + 1; k > j + 1; k--) {
                            list.getNode(k).setValue(list.get(k - 1));
                            posicion = k - 1;
                        }
                        list.getNode(posicion).setValue(temp);
                    }
                }
            }
        }
        return list;
    }
}
