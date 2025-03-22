package ejercicios;

import estructuras.*;

public class Taller<E> {

    // ========================== Punto número 1 ==========================
    public static void replace(Stack<Integer> stack, int newValue, int old) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int valor = stack.pop();
            if (valor == old) {
                temp.push(newValue); // Reemplaza la primera ocurrencia de "old".
                break;
            }
            temp.push(valor);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop()); // Restaura los elementos en la pila original.
        }
    }

    // ========================== Punto número 2 ==========================
    public static void smallerToDeepest(Stack<Integer> stack) {
        Stack<Integer> auxStack = new Stack<>();
        Node<Integer> currentNode = stack.getTop();

        int menor = currentNode.getValue();

        while (!stack.isEmpty()) {
            if (menor > currentNode.getValue()) {
                menor = currentNode.getValue(); // Encuentra el menor valor.
            }
            if (stack.getTop() != null) {
                auxStack.push(stack.pop()); // Pasa elementos a la pila auxiliar.
                currentNode = stack.getTop();
            }
        }
        stack.push(menor); // Coloca el menor valor en el fondo.

        while (!auxStack.isEmpty()) {
            if (auxStack.getTop().getValue() != menor) {
                stack.push(auxStack.pop()); // Restaura los elementos excepto los repetidos
            } else {
                auxStack.pop();
            }
        }
    }

    // ========================== Punto número 3 ==========================
    public static void reorderStack(Stack<Integer> stack, int value) {
        Stack<Integer> auxStack = new Stack<>();
        Node<Integer> currentNode = stack.getTop();
        boolean find = false;
        int newTop = value;

        while (currentNode != null && !find) {
            if (currentNode.getValue() == value) {
                newTop = stack.pop(); // Extrae el valor y lo almacena.
                find = true;
            } else {
                auxStack.push(stack.pop()); // Pasa elementos a la pila auxiliar.
                currentNode = stack.getTop();
            }
        }

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop()); // Restaura los elementos en la pila original.
        }
        stack.push(newTop);
    }

    // ========================== Punto número 4 ==========================
    public static void reorderQueue(Queue<Integer> queue, int value) {
        Node<Integer> currentNode = queue.getHead();
        Node<Integer> newHead = new Node<>(value);
        int contador = 0;
        int reference = queue.getSize();

        while (contador != reference) {
            if (currentNode.getValue() == value) {
                queue.dequeue();
            } else {
                queue.enqueue(queue.dequeue()); // Rota los elementos manteniendo el orden.
            }
            currentNode = queue.getHead();
            contador++;
        }
        queue.addBeginning(newHead); // Coloca "value" al inicio de la cola.
    }

}
