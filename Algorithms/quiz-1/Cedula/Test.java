package Cedula;

import java.util.Scanner;
import linkedListG.LinkedList;

//Escriba un algoritmo que haciendo
// uso de un arreglo unidimensional de 100
// elementos denominado CEDULA, permita:
// – Leer los 100 elementos por teclado.
// – Ordenar los números de cédula de forma
// ascendente.
// – Buscar si el número de cédula 19144473 se
// encuentra en el arreglo CEDULA e indicar la
// posición que ocupa.
// – Determinar cuántos números de cédula son
// mayores a 19145954.

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list;
        try ( // int[] numeros = {
              // 19144473, 19145000, 19146000, 19147000, 19148000, 19149000, 19150000,
              // 19151000, 19152000, 19153000,
              // 19154000, 19155000, 19156000, 19157000, 19158000, 19159000, 19160000,
              // 19161000, 19162000, 19163000,
              // 19164000, 19165000, 19166000, 19167000, 19168000, 19169000, 19170000,
              // 19171000, 19172000, 19173000,
              // 19174000, 19175000, 19176000, 19177000, 19178000, 19179000, 19180000,
              // 19181000, 19182000, 19183000,
              // 19184000, 19185000, 19186000, 19187000, 19188000, 19189000, 19190000,
              // 19191000, 19192000, 19193000,
              // 19194000, 19195000, 19196000, 19197000, 19198000, 19199000, 19200000,
              // 19201000, 19202000, 19203000,
              // 19204000, 19205000, 19206000, 19207000, 19208000, 19209000, 19210000,
              // 19211000, 19212000, 19213000,
              // 19214000, 19215000, 19216000, 19217000, 19218000, 19219000, 19220000,
              // 19221000, 19222000, 19223000,
              // 19224000, 19225000, 19226000, 19227000, 19228000, 19229000, 19230000,
              // 19231000, 19232000, 19233000,
              // 19234000, 19235000, 19236000, 19237000, 19238000, 19239000, 19240000,
              // 19241000, 19242000, 19243000
              // };
                Scanner scanner = new Scanner(System.in)) {
            list = new LinkedList<>();
            for (int i = 0; i < 100; i++) {
                System.out.print("Ingrese un número (este es el número" + (i + 1) + ")");
                int numero = scanner.nextInt();
                list.addLast(numero);

            }
        }

        // for(int i = 0; i < 100; i++){
        // list.addLast(numeros[i]);
        // }

        Cedulas c = new Cedulas(list);
        c.ordenar();
        System.out.println("Las cédulas en orden son: ");
        for (int i = 0; i < c.getCedulas().getSize(); i++) {
            System.out.println(c.getCedulas().get(i));
        }
        int existencia = c.existeNumero();

        if (existencia != -1) {
            System.out.println("La Cédula 19144473 está en la posición: " + existencia); // teniendo en cuenta que la
                                                                                         // posicion es cuando ya está
                                                                                         // ordenado,sino
        } // tocaría llamar la función antes de ordenar
        else {
            System.out.println("La Cédula 19144473 no se encuentra ");
        }

        System.out.println("Hay " + c.numerosMayores() + " números mayores que 19145954");

    }

}
