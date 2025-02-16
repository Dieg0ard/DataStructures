import java.util.Arrays;
import java.util.Scanner;

public class CedulaManager {

    private final int TAMANIO = 100;
    private int[] cedulas;

    CedulaManager(){
        this.cedulas = new int[TAMANIO];
    }
    // Método para leer las cédulas desde el teclado
    public void leerCedulas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese las " + TAMANIO + " cedulas");
        for (int i = 0; i < TAMANIO; i++) {
            cedulas[i] = scanner.nextInt();
        }
        scanner.close();
    }

    public void ordenarCedulas() {
        Arrays.sort(cedulas);
    }

    public int buscarCedula(int numero) {
        int posicion = Arrays.binarySearch(cedulas, numero);
        return (posicion >= 0) ? posicion : -1;
    }

    public int contarCedulasMayores(int limite) {
        int contador = 0;
        for (int cedula : cedulas) {
            if (cedula > limite) {
                contador++;
            }
        }
        return contador;
    }


}
