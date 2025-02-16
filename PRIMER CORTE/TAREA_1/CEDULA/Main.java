public class Main{
    public static void main(String[] args) {
        CedulaManager manager = new CedulaManager();

        manager.leerCedulas();
        manager.ordenarCedulas();

        int cedulaBuscar = 19144473;
        int posicion = manager.buscarCedula(cedulaBuscar);
        if (posicion != -1) {
            System.out.println("La cédula " + cedulaBuscar + " está en la posición " + posicion + ".");
        } else {
            System.out.println("La cédula " + cedulaBuscar + " no se encuentra en el arreglo.");
        }

        int cedulaLimite = 19145954;
        int cantidadMayores = manager.contarCedulasMayores(cedulaLimite);
        System.out.println("Cantidad de cédulas mayores a " + cedulaLimite + ": " + cantidadMayores);
    }
}