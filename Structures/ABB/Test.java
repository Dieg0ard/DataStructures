package ABB;

public class Test {
    public static void main(String[] args) {
        Abb arbol = new Abb();
        arbol.add(1);
        arbol.add(8);
        arbol.add(3);
        arbol.add(11);
        arbol.add(5);
        arbol.add(17);
        arbol.add(13);
        arbol.add(0);
        arbol.add(Integer.MIN_VALUE);
        arbol.add(Integer.MAX_VALUE);

        // System.out.println("El maximo par es: " + arbol.maximoPar(arbol.getRaiz()));
        // System.out.println("Peso del arbol: " + arbol.size(arbol.getRaiz()));
        // System.out.println("Mayor: " + arbol.getMax(arbol.getRaiz()));
        // System.out.println("Menor: " + arbol.getMin(arbol.getRaiz()));
        System.out.println("Número de hojas: " + arbol.countLeaves(arbol.getRaiz()));
        System.out.println("Número de nodos internos: " + arbol.countInternalNodes(arbol.getRaiz()));

    }
}
