package Stack;

import java.util.Scanner;

public class Test {

    
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        int option;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Apilar");
            System.out.println("2. Desapilar");
        
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();  //limpia el buffer para que al usar nextLine tome el valor

            switch (option) {
                case 1:
                    System.out.print("Ingrese el valor: ");
                    String value1 = scanner.nextLine();
                    stack.push(value1);
                    stack.printStack();
                    System.out.println("Size: " + stack.getSize());
                    break;
                case 2:
                   
                    
                    String s = stack.pop();
                    stack.printStack();
                    System.out.println("Size: " + stack.getSize() + "Eliminado: " + s);
                    break;
                

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);

        scanner.close();
    
    
}
    
}
