import java.util.Arrays;

public class CedulaManager {
    private int[] cedulas;

    public CedulaManager() {
        this.cedulas = new int[100];
    }

    public void setCedulas(int[] cedulas) {
        if (cedulas.length == 100) {
            this.cedulas = cedulas;
        } else {
            throw new IllegalArgumentException("El arreglo debe contener exactamente 100 elementos.");
        }
    }

    public void ordenarCedulas() {
        Arrays.sort(cedulas);
    }

    public int buscarCedula(int cedula) {
        int posicion = Arrays.binarySearch(cedulas, cedula);
        return (posicion >= 0) ? posicion : -1;
    }

    public int contarCedulasMayores(int cedula) {
        int contador = 0;
        for (int numero : cedulas) {
            if (numero > cedula) {
                contador++;
            }
        }
        return contador;
    }

    public void mostrarCedulas() {
        for (int numero : cedulas) {
            System.out.println(numero + ",");
        }
    }
}

