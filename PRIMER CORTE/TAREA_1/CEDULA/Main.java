public class Main {
    public static void main(String[] args) {
        CedulaManager manager = new CedulaManager();

        // Simulando entrada de cédulas con valores aleatorios
        int[] datosPrueba = {
            19345678, 19144473, 19234567, 19456789, 19567890, 19012345, 19156789, 19678901, 19321098, 19245678,
            19789012, 19890123, 19901234, 19543210, 19432109, 19387654, 19298765, 19123456, 19098765, 19987654,
            19876543, 19765432, 19654321, 19543210, 19432109, 19321098, 19210987, 19199876, 19088765, 19977654,
            19866543, 19755432, 19644321, 19533210, 19422109, 19311098, 19200987, 19190876, 19080765, 19970654,
            19860543, 19750432, 19640321, 19530210, 19420109, 19310098, 19200987, 19190876, 19080765, 19960654,
            19850543, 19740432, 19630321, 19520210, 19410109, 19300098, 19290987, 19180876, 19070765, 19950654,
            19840543, 19730432, 19620321, 19510210, 19400109, 19390098, 19280987, 19170876, 19060765, 19940654,
            19830543, 19720432, 19610321, 19500210, 19390109, 19280098, 19170987, 19060876, 19930654, 19820543,
            19710432, 19600321, 19490109, 19380098, 19270987, 19160876, 19050765, 19920654, 19810543, 19700432,
            19590321, 19480109, 19370098, 19260987, 19150876, 19040765, 19910654, 19800543, 19690432, 19580321
        };

        manager.setCedulas(datosPrueba);
        manager.ordenarCedulas();
        manager.mostrarCedulas();

        int cedulaBuscada = 19144473;
        int posicion = manager.buscarCedula(cedulaBuscada);
        if (posicion != -1) {
            System.out.println("\nLa cédula " + cedulaBuscada + " está en la posición: " + posicion);
        } else {
            System.out.println("\nLa cédula " + cedulaBuscada + " no fue encontrada.");
        }

        int umbral = 19145954;
        System.out.println("\nCantidad de cédulas mayores a " + umbral + ": " + manager.contarCedulasMayores(umbral));
    }
}

