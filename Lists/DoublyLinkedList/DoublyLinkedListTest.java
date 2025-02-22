package DoublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar al inicio");
            System.out.println("2. Agregar al final");
            System.out.println("3. Agregar en un índice específico");
            System.out.println("4. Eliminar el primer elemento");
            System.out.println("5. Eliminar el último elemento");
            System.out.println("6. Eliminar en un índice específico");
            System.out.println("7. Limpiar la lista");
            System.out.println("8. Mostrar lista");
            System.out.println("9. Mostrar lista en orden inverso");
            System.out.println("10. Obtener tamaño de la lista");
            System.out.println("11. Verificar si está vacía");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a agregar al inicio: ");
                    int valInicio = scanner.nextInt();
                    list.addFirst(valInicio);
                    break;
                case 2:
                    System.out.print("Ingrese el valor a agregar al final: ");
                    int valFinal = scanner.nextInt();
                    list.addLast(valFinal);
                    break;
                case 3:
                    System.out.print("Ingrese el índice: ");
                    int indexAdd = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    int valIndex = scanner.nextInt();
                    try {
                        list.addAtIndex(indexAdd, valIndex);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        list.removeFirst();
                        System.out.println("Primer elemento eliminado.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        list.removeLast();
                        System.out.println("Último elemento eliminado.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el índice a eliminar: ");
                    int indexRemove = scanner.nextInt();
                    try {
                        list.removeAtIndex(indexRemove);
                        System.out.println("Elemento en el índice " + indexRemove + " eliminado.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 7:
                    list.clear();
                    System.out.println("Lista vaciada.");
                    break;
                case 8:
                    System.out.println("Lista en orden:");
                    list.display();
                    break;
                case 9:
                    System.out.println("Lista en orden inverso:");
                    list.displayReverse();
                    break;
                case 10:
                    System.out.println("Tamaño de la lista: " + list.getSize());
                    break;
                case 11:
                    System.out.println(list.isEmpty() ? "La lista está vacía." : "La lista no está vacía.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            
            // Mostrar lista después de cada operación
            System.out.println("Lista actual:");
            list.display();
        }
    }
}
