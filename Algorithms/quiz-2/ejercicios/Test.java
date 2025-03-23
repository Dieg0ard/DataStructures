package ejercicios;

import estructuras.*;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new Queue<>();

        // Agregar elementos a la pila
        stack.push(20);
        stack.push(10);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Agregar elementos a la cola
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        // Mostrar pila antes de operaciones
        System.out.println("Pila antes de operaciones:");
        stack.printStack();

        // Probar replace
        Taller.replace(stack, 99, 20);
        System.out.println("\nPila después de replace:");
        stack.printStack();

        // Probar smallerToDeepest
        Taller.smallerToDeepest(stack);
        System.out.println("\nPila después de smallerToDeepest:");
        stack.printStack();

        // Probar reorderStack
        Taller.reorderStack(stack, 30);
        System.out.println("\nPila después de reorderStack:");
        stack.printStack();

        // Mostrar cola antes de operaciones
        System.out.println("\nCola antes de reorderQueue:");
        queue.printQueue();

        // Probar reorderQueue con varios casos
        Taller.reorderQueue(queue, 5); // Debería mover el 5 al inicio
        System.out.println("\nCola después de reorderQueue con 5:");
        queue.printQueue();

        Taller.reorderQueue(queue, 10); // Debería mover el 10 al inicio
        System.out.println("\nCola después de reorderQueue con 10:");
        queue.printQueue();

        Taller.reorderQueue(queue, 15); // No está en la cola, debería agregarlo al inicio
        System.out.println("\nCola después de reorderQueue con 15:");
        queue.printQueue();

        Taller.reorderQueue(queue, 3); // Debería mover el 3 al inicio
        System.out.println("\nCola después de reorderQueue con 3:");
        queue.printQueue();
    }
}
