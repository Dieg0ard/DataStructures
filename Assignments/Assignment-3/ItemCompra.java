import java.util.Objects;

public class ItemCompra {

    private Libro libro = new Libro();
    private int cantidad;

    public ItemCompra() {

    }

    @Override
    public boolean equals(Object item) {
        boolean rta = false;
        if (item instanceof ItemCompra it) {
            if (this.libro.getIsbn().equals(it.getLibro().getIsbn())) {
                rta = true;
            }
        }
        return rta;

    }

    @Override
    public int hashCode() {
        return Objects.hash(libro.getIsbn());
    }

    public ItemCompra(int cantidad, Libro libro) {
        this.libro = libro;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public int getValorItem(){
        return libro.getPrecio() * cantidad;
    }


}
