package ABB;

public class Abb {
    private Node raiz;

    // Devuelve la raíz del árbol
    public Node getRaiz() {
        return raiz;
    }

    // Asigna una nueva raíz al árbol
    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    // Inserta un nuevo elemento en el ABB (Árbol Binario de Búsqueda)
    public void add(int elemento) {
        if (raiz == null) {
            raiz = new Node(elemento);
        } else {
            raiz.add(elemento); // inserta recursivamente en la posición correcta
        }
    }

    // Recorrido inorden: izquierda - raíz - derecha (muestra los datos ordenados)
    public void inorden(Node node) {
        if (node != null) {
            inorden(node.getLeft());
            System.out.println("Dato: " + node.getValue());
            inorden(node.getRight());
        }
    }

    // Recorrido preorden: raíz - izquierda - derecha
    public void preorden(Node node) {
        if (node != null) {
            System.out.println("Dato: " + node.getValue());
            preorden(node.getLeft());
            preorden(node.getRight());
        }
    }

    // Calcula el número total de nodos del árbol
    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    // Retorna el valor par más grande del árbol (o Integer.MIN_VALUE si no hay pares)
    public int maximoPar(Node node) {
        int maxPar = Integer.MIN_VALUE;
        if (node == null) {
            return maxPar;
        }
        if (node.getValue() % 2 == 0) {
            maxPar = Math.max(maxPar, node.getValue());
        }
        // Busca el máximo par en los subárboles
        if (node.getLeft() != null) {
            maxPar = Math.max(maxPar, maximoPar(node.getLeft()));
        }
        if (node.getRight() != null) {
            maxPar = Math.max(maxPar, maximoPar(node.getRight()));
        }
        return maxPar;
    }

    // Devuelve el valor máximo del ABB (último nodo a la derecha)
    public int getMax(Node node) {
        if (node.getRight() == null) {
            return node.getValue();
        }
        return getMax(node.getRight());
    }

    // Devuelve el valor mínimo del ABB (último nodo a la izquierda)
    public int getMin(Node node) {
        if (node.getLeft() == null) {
            return node.getValue();
        }
        return getMin(node.getLeft());
    }

    // Verifica si el árbol está vacío
    public boolean isEmpty() {
        return getRaiz() == null;
    }

    // Verifica si un nodo es hoja (no tiene hijos)
    public boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    // Cuenta cuántos nodos hoja hay en el árbol
    public int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }

    // Cuenta cuántos nodos internos (no hoja) hay en el árbol
    public int countInternalNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 0;
        }
        return 1 + countInternalNodes(node.getLeft()) + countInternalNodes(node.getRight());
    }
}
