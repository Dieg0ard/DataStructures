import java.text.DecimalFormat;

public class TestTiendaLibros {
    public static void main(String[] args) {
         DecimalFormat df = new DecimalFormat("#,###");
        // Crear instancia de TiendaLibros
        TiendaLibros tienda = new TiendaLibros();

        // Crear 10 libros
        Libro libro1 = new Libro("El Principito", "978-3-16-148410-0", 25250);
        Libro libro2 = new Libro("Cien años de soledad", "978-84-376-0494-7", 45250);
        Libro libro3 = new Libro("Don Quijote", "978-84-670-0638-7", 30800);
        Libro libro4 = new Libro("1984", "978-0-452-28423-4", 32500);
        Libro libro5 = new Libro("Moby Dick", "978-0-14-243724-7", 28150);
        Libro libro6 = new Libro("Orgullo y Prejuicio", "978-1-85326-000-1", 35700);
        Libro libro7 = new Libro("La Odisea", "978-0-14-026886-7", 27000);
        Libro libro8 = new Libro("Crimen y Castigo", "978-0-14-305814-4", 38950);
        Libro libro9 = new Libro("Hamlet", "978-0-7434-7712-3", 26000);
        Libro libro10 = new Libro("El Gran Gatsby", "978-0-7432-7356-5", 29000);

        // Agregar libros al catálogo
        tienda.agregarLibro(libro1);
        tienda.agregarLibro(libro2);
        tienda.agregarLibro(libro3);
        tienda.agregarLibro(libro4);
        tienda.agregarLibro(libro5);
        tienda.agregarLibro(libro6);
        tienda.agregarLibro(libro7);
        tienda.agregarLibro(libro8);
        tienda.agregarLibro(libro9);


        // Intentar agregar items al carrito solo si el libro existe en el catálogo
        tienda.agregarCarro(2, libro1);
        tienda.agregarCarro(1, libro4);
        tienda.agregarCarro(3, libro6);
        tienda.agregarCarro(2, libro9);
        tienda.agregarCarro(1, libro2);
        tienda.agregarCarro(1, libro10); //No está en el catalogo, no se añadirá

        // Mostrar contenido del carrito antes de retirar

        System.out.println("Catálogo:");
        for (Libro libro : tienda.getCatalogo()) {
            System.out.println("Libro: " + libro.getTitulo());
        }

        System.out.println("\n Contenido del carrito antes de retirar:");
        for (ItemCompra item : tienda.getCarro().getItems()) {
            System.out.println("Libro: " + item.getLibro().getTitulo() + ", Cantidad: " + item.getCantidad() + ", Precio: " + df.format(item.getValorItem()));
        }
        System.out.println("Valor total en el carrito: " + df.format(tienda.getPrecioTotal()));

        // Retirar 'El Principito' del carrito
        Libro libroRetirado = new Libro("prueba", "978-3-16-148410-0", 0);
        boolean retirado = tienda.retirarCarro(libroRetirado);
        System.out.println("\n¿Se retiró 'El Principito' del carrito? " + retirado);

        // Mostrar contenido del carrito después de retirar
        System.out.println("\nContenido del carrito después de retirar:");
        for (ItemCompra item : tienda.getCarro().getItems()) {
            System.out.println("Libro: " + item.getLibro().getTitulo() + ", Cantidad: " + item.getCantidad()+ ", Precio: " + df.format(item.getValorItem()));
        }
        System.out.println("Valor total en el carrito: " + df.format(tienda.getPrecioTotal()));
    }
}
