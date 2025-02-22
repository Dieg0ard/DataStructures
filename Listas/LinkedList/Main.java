package LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un elemento al final");
            System.out.println("2. Agregar un elemento al inicio");
            System.out.println("3. Eliminar un elemento");
            System.out.println("4. Mostrar la lista");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar al final: ");
                    int addLastValue = scanner.nextInt();
                    list.addLast(addLastValue);
                    System.out.println("Lista después de agregar al final: ");
                    list.display();
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a agregar al inicio: ");
                    int addFirstValue = scanner.nextInt();
                    list.addFirst(addFirstValue);
                    System.out.println("Lista después de agregar al inicio: ");
                    list.display();
                    break;
                case 3:
                    System.out.print("Ingrese el elemento a eliminar: ");
                    int removeValue = scanner.nextInt();
                    if (list.remove(removeValue)) {
                        System.out.println("Elemento eliminado.");
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    System.out.println("Lista después de eliminar: ");
                    list.display();
                    break;
                case 4:
                    System.out.println("Lista actual: ");
                    list.display();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}
