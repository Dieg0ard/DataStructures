package Algoritmos;

import linkedListG.*;

//list.get() returns the value, list.getNode() returns the node
public class InsertionSortList {

    public static LinkedList<Integer> insertionSort(LinkedList<Integer> list) {

        for (int i = 0; i < list.getSize() - 1; i++) {

            // si la primera vez, el numero de la derecha es menor que el inicial
            if (i == 0 && list.get(i + 1) < list.get(i)) {
                int temp = list.get(i + 1);
                list.getNode(i + 1).setValue(list.get(i));
                list.getNode(i).setValue(temp);
            }

            // para el resto de casos, manejar la parte ordenada del arreglo
            // y encontrar la posicion del nuevo elemento
            if (list.get(i + 1) < list.get(i)) {
                // agregar al inicio
                for (int j = 0; j < i; j++) { // ciclo que se mueve por los elementos ordenados, para encontrar
                                              // la posicion a donde pertenece si se cumple la condicion dada
                    if (list.get(i + 1) < list.get(j)) { // si el numero que se va a agregar es el mas pequeña
                        int temp = list.get(i + 1);

                        for (int k = i + 1; k > 0; k--) {
                            list.getNode(k).setValue(list.get(k - 1)); // empieza a mover los elementos
                        }
                        list.getFirstNode().setValue(temp); // cuando el elemento es el menor de todos
                    }
                    if (list.get(i + 1) >= list.get(j) && list.get(i + 1) < list.get(j + 1)) {// busca la posicion que
                                                                                              // corresponde en la parte
                                                                                              // ordenada
                        int temp = list.get(i + 1); // del arreglo, cuando está en la posicon donde va el elemento, deja
                                                    // de mover a la derecha
                        // dejando el espacio que requiere y lo inserta
                        int posicion = 0;
                        for (int k = i + 1; k > j + 1; k--) {
                            list.getNode(k).setValue(list.get(k - 1)); // abre espacio en la posicion correspondiente
                            posicion = k - 1;
                        }
                        list.getNode(posicion).setValue(temp); // sale con la posicion donde se debe insertar el
                                                               // elemento
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int data[] = { 4, 3, 2, 2, 1, 5, 6, 8, 23, 2, -1, -3, 0 };
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            list.addLast(data[i]);
        }
        list.printList();

        LinkedList<Integer> result = insertionSort(list);
        System.out.print("[");
        for (int i = 0; i < result.getSize(); i++) {
            if (i == result.getSize() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + ",");
            }

        }
        System.out.print("]");

    }

}
