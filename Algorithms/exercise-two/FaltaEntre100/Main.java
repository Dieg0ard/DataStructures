public class Main {
    public static void main(String[] args) {

        int[] array = new int[99];
        Algoritmo algoritmo = new Algoritmo();

        int index = 0;
        for (int i = 1; i <= 100; i++) {
            // Se llena el array con números del 1 al 100 menos el de la condición
            if (i != 15) {
                array[index] = i;
                index++;
            }
        }
        // Se imprime el resultado
        System.out.println("El número faltante es: " + algoritmo.encontrarFaltante(array));
    }

}