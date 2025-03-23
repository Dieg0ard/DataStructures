public class Algoritmo {

    public int encontrarFaltante(int arr[]) {
        int sumatoria = 0;
        for (int i = 0; i < arr.length; i++) {
            sumatoria += arr[i];
        }
        // la sumatoria de los números del 1 al 100 es 5050
        // la diferencia entre ese número y la sumatoria del array es el número faltante
        return 5050 - sumatoria;
    }
}// Fin clase Algoritmo
