public class Main {
    public static void main(String[] args) {
        ArrayManager manager = new ArrayManager();
        int[] array = {23, -14, -18, 42, 3, 7, 19, 56, 98, 33};
        
        manager.sort(array);

        System.out.println("Menor del arreglo: " + array[0]);
        System.out.println("Mayor del arreglo: " + array[array.length-1]);
    }
    
}
