package Cedula;

import Algoritmos.BusquedaBinariaList;
import Algoritmos.InsertionSortList;
import linkedListG.*;
//el primer metodo a llamar debe ser el de ordenar

public class Cedulas {
      private LinkedList<Integer> cedulas;
      
      Cedulas(){

      }

      Cedulas(LinkedList<Integer> cedulas){
        this.cedulas = cedulas;
      }

      public void ordenar(){
        this.cedulas = InsertionSortList.insertionSort(cedulas);
      }
      //para que la busqueda binaria sirva primero ordenar
      public int existeNumero(){
        return BusquedaBinariaList.busquedaBinaria(cedulas, 19144473 );
        }
 
      public int numerosMayores(){
        int mayores = 0;
        for(int i = 0; i < cedulas.getSize(); i++){
           if(cedulas.get(i) > 19145954 ){  //si se garantiza que la cedula 19145954  podriamos restarle a 100 la poscion de donde
             mayores++;                    //se encuentra +1, pero puede que el elemento no esté, solo dice mayores a él
           } 
         }
        
        return mayores;
        
      }

      public LinkedList<Integer> getCedulas(){
        return this.cedulas;
      }

      public void setCedulas(LinkedList<Integer> list){
         this.cedulas = list;
      }
}

