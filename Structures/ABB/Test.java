package ABB;

public class Test {
    public static void main(String[] args) {
        Abb tree = new Abb();

        // Insertar elementos
        int[] values = {50, 30, 70, 20, 40, 60, 80, 35, 45, 65, 75, 90, 10};
        for (int val : values) {
            tree.add(val);
        }

        System.out.println("=== Inorden (debería estar ordenado) ===");
        tree.inorden();

        System.out.println("\n=== Preorden ===");
        tree.preorden();

        System.out.println("\n=== Postorden ===");
        tree.postorden();

        System.out.println("\n=== Tamaño del árbol ===");
        System.out.println("Total de nodos: " + tree.size());

        System.out.println("\n=== Contiene 45? ===");
        System.out.println(tree.contains(45)); // true

        System.out.println("\n=== Contiene 99? ===");
        System.out.println(tree.contains(99)); // false

        System.out.println("\n=== Valor mínimo ===");
        System.out.println(tree.getMin()); // 10

        System.out.println("\n=== Valor máximo ===");
        System.out.println(tree.getMax()); // 90

        System.out.println("\n=== Máximo valor par ===");
        System.out.println(tree.maxEven()); // debería ser 90

        System.out.println("\n=== ¿Está vacío? ===");
        System.out.println(tree.isEmpty()); // false

        System.out.println("\n=== ¿Es hoja la raíz? ===");
        System.out.println(tree.isLeaf(tree.getRaiz())); // false

        System.out.println("\n=== Número de hojas ===");
        System.out.println(tree.countLeaves());

        System.out.println("\n=== Número de nodos internos ===");
        System.out.println(tree.countInternalNodes());

        System.out.println("\n=== Buscar nodo con valor 65 ===");
        Node node = tree.find(65);
        System.out.println(node != null ? "Encontrado: " + node.getValue() : "No encontrado");

        System.out.println("\n=== Eliminar nodo 70 (con dos hijos) ===");
        tree.remove(70);
        System.out.println(tree);

        System.out.println("\n=== Eliminar nodo 20 (hoja) ===");
        tree.remove(20);
        System.out.println(tree);

        System.out.println("\n=== Eliminar nodo 30 (con un hijo) ===");
        tree.remove(30);
        System.out.println(tree);
    }
}
