import java.util.LinkedList;
import java.util.List;

public class TiendaLibros {

    private final List <Libro> catalogo = new LinkedList<>();
    private final CarroCompras carro = new CarroCompras();


    public void agregarLibro(Libro libro){
       catalogo.add(libro);

    }

    public boolean agregarCarro(int cantidad, Libro libro){
        boolean rta = false;
        if(existeLibro(libro)){
            ItemCompra item = new ItemCompra(cantidad, libro);
            carro.agregarItem(item);
            rta = true;
        }
        return rta;
        

    }

    public boolean retirarCarro(Libro libro){
        boolean rta = false;
        if(carro.existeItem(0, libro)){
            ItemCompra item = new ItemCompra(0, libro);
            carro.eliminarItem(item); // ver como funciona internamente el metodo de eliminar
            rta = true;
        }
        return rta;
        
    }
    
    public boolean existeLibro(Libro libro) {
        return catalogo.contains(libro);
    }
    

    public List<Libro> getCatalogo(){
        return this.catalogo;
    }

    public int getPrecioTotal(){
        return carro.getPrecioTotal();
    }

    public CarroCompras getCarro(){
        return this.carro;
    }


    
}
