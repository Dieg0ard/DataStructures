import java.util.LinkedList;
import java.util.List;

public class CarroCompras {

    private final List<ItemCompra> items = new LinkedList<>();
   
    public boolean existeItem(int cantidad, Libro libro){
        boolean rta = false;
        
         ItemCompra item = new ItemCompra(cantidad, libro);
         if(items.contains(item)){
            rta = true;
         }
         return rta; 

    }

    public int getPrecioTotal(){
        int salida = 0;
        for(ItemCompra item: items){
            salida += item.getLibro().getPrecio() * item.getCantidad();
        }
        return salida;
    }


    public void agregarItem(ItemCompra item){
          items.add(item);
    }

    public void eliminarItem(ItemCompra item){
         items.remove(item);
    }

    public List<ItemCompra> getItems(){
        return this.items;
    }
    
}
