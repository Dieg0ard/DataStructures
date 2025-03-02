package Algoritmos;

import linkedListG.*;

public class BusquedaBinariaList {

    public static int busquedaBinaria(LinkedList<Integer> list, int objetivo) {
        int izquierda = 0, derecha = list.getSize() - 1;
    

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (list.get(medio) == objetivo)
                return medio; // Elemento encontrado

            if (list.get(medio) < objetivo)
                izquierda = medio + 1; // Buscar en la derecha
            else
                derecha = medio - 1; // Buscar en la izquierda
        }
        return -1; // No encontrado
    }

    public static void main(String[] args) {
        int data[] = {-3,-1,0,1,2,2,2,3,4,5,6,8,23};
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < data.length; i++){
           list.addLast(data[i]);
        }
        int objetivo = -3;
        int resultado = busquedaBinaria(list, objetivo);
    
        if (resultado != -1) {
            System.out.println("Elemento encontrado en la posición: " + resultado);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
    
}


