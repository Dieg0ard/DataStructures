public class NotasManager {
    int aprobados, desaprobados;
    Nota[] NOTAS = new Nota[58];
    boolean ordenado;
    int promedio;

    public NotasManager() {
        ordenado = false;
    }

    public void imprimirResumen(){
        ordenar();
        calcularAprobados();
        System.out.println("Nota promedio de la clase: " + getPromedioNotas());

        System.out.println("Nota más alta: " + getNotaMasAlta().getNota()
                            + " de " + getNotaMasAlta().getEstudiante());

        System.out.println("Nota más baja: " + getNotaMasBaja().getNota() 
                            + " de " + getNotaMasBaja().getEstudiante());

        System.out.println("Notas superiores a 18: " +getNotasSuperiores());

        System.out.println("Notas superiores al promedio: " + getNotasSuperioresAlPromedio());

        System.out.println("Porcentaje de aprobados: " + (aprobados*100)/NOTAS.length+"%");

        System.out.println("Porcentaje de desaprobados: " + (desaprobados*100)/NOTAS.length+"%");

    }

    public void ordenar() {
        quicksort(NOTAS, 0, NOTAS.length-1);
    }

    public static void quicksort(Nota[] arr, int left, int right) {
        if (left >= right) return; // Caso base
        
        int pivotIndex = partition(arr, left, right);
        
        quicksort(arr, left, pivotIndex);   // Ordenar la parte izquierda
        quicksort(arr, pivotIndex + 1, right); // Ordenar la parte derecha
    }
    
    private static int partition(Nota[] arr, int left, int right) {
        int pivot = arr[left].getNota(); // Elegimos el primer elemento como pivote
        int i = left - 1, j = right + 1;
        
        while (true) {
            do { i++; } while (arr[i].getNota() < pivot);
            do { j--; } while (arr[j].getNota() > pivot);
            
            if (i >= j) return j; // Punto de separación
            
            // Intercambiamos los elementos fuera de lugar
            Nota temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    public Nota getNotaMasAlta() {
        if (!ordenado) {
            ordenar();
        }
        return NOTAS[NOTAS.length - 1];
    }

    public Nota getNotaMasBaja() {
        if (!ordenado) {
            ordenar();
        }
        return NOTAS[0];
    }

    public int getPromedioNotas(){
        int suma = 0;
        for (Nota nota : NOTAS) {
            suma += nota.getNota();
        }
        promedio = suma / NOTAS.length;
        return promedio;
    }

    public int getNotasSuperiores() {
        if (NOTAS == null || NOTAS.length == 0) {
            return 0; 
        }
        if (!ordenado) {
            ordenar();
        }
        int notasSuperiores = 0;
        int index = NOTAS.length - 1;
    
        while (index >= 0 && NOTAS[index].getNota() >= 18) {
            notasSuperiores++;
            index--;
        }
    
        return notasSuperiores;
    }

    public int getNotasSuperioresAlPromedio() {
        if (NOTAS == null || NOTAS.length == 0) {
            return 0; 
        }
        if (!ordenado) {
            ordenar();
        }
        int notasSuperiores = 0;
        int index = NOTAS.length - 1;
    
        while (index >= 0 && NOTAS[index].getNota() > promedio) {
            notasSuperiores++;
            index--;
        }
    
        return notasSuperiores;
    }

    public void calcularAprobados(){
        int notaParaAprobar = 11;
        int indice = 0;
        
        for(int i = 0; i < NOTAS.length; i++){
            if (NOTAS[i].getNota() >= notaParaAprobar) {
                indice = i;
                break;
            }
        }
        
        desaprobados = indice; 
        aprobados = NOTAS.length - indice;

    }
    
}