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
        arbol.add(24);
        
        System.out.println("El maximo par es: " + arbol.maximoPar(arbol.getRaiz()));
        System.out.println("Peso del arbol: " + arbol.size(arbol.getRaiz()));
        // System.out.println("InOrden:");
        // arbol.inorden(arbol.getRaiz());
        // System.out.println("PreOrden:");
        // arbol.preorden(arbol.getRaiz());
    }
}
