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

    // Inserta un nuevo elemento en el Arbol
    public void add(int elemento) {
        if (raiz == null) {
            raiz = new Node(elemento);
        } else {
            raiz.add(elemento); // inserta recursivamente en la posición correcta
        }
    }

    public boolean remove(int value) {
        if (find(value) == null) {
            return false; // Valor no encontrado
        }
        raiz = remove(raiz, value);
        return true;
    }

    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            node.setLeft(remove(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(remove(node.getRight(), value));
        } else {
            // Caso 1: nodo sin hijos
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }

            // Caso 2: un solo hijo
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }

            // Caso 3: dos hijos
            // Se busca el sucesor inorden (mínimo del subárbol derecho)
            int minValue = getMin(node.getRight());
            node.setValue(minValue);
            node.setRight(remove(node.getRight(), minValue));
        }

        return node;
    }

    // Recorrido inorden: izquierda - raíz - derecha (muestra los datos ordenados)
    public void inorden() {
        inorden(raiz);
    }

    private void inorden(Node node) {
        if (node != null) {
            inorden(node.getLeft());
            System.out.println("Dato: " + node.getValue());
            inorden(node.getRight());
        }
    }

    // Recorrido preorden: raíz - izquierda - derecha
    public void preorden() {
        preorden(raiz);
    }

    private void preorden(Node node) {
        if (node != null) {
            System.out.println("Dato: " + node.getValue());
            preorden(node.getLeft());
            preorden(node.getRight());
        }
    }

    // Recorrido postorden: izquierda - derecha - raíz
    public void postorden() {
        postorden(raiz);
    }

    private void postorden(Node node) {
        if (node != null) {
            postorden(node.getLeft());
            postorden(node.getRight());
            System.out.println("Dato: " + node.getValue());
        }
    }

    // Calcula el número total de nodos del árbol
    public int size() {
        return size(raiz);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    // Retorna el valor par más grande del árbol (o Integer.MIN_VALUE si no hay
    // pares)
    public int maxEven() {
        return maxEven(raiz);
    }

    private int maxEven(Node node) {
        int maxEven = Integer.MIN_VALUE;
        if (node == null) {
            return maxEven;
        }
        if (node.getValue() % 2 == 0) {
            maxEven = Math.max(maxEven, node.getValue());
        }
        // Busca el máximo par en los subárboles
        if (node.getLeft() != null) {
            maxEven = Math.max(maxEven, maxEven(node.getLeft()));
        }
        if (node.getRight() != null) {
            maxEven = Math.max(maxEven, maxEven(node.getRight()));
        }
        return maxEven;
    }

    // Devuelve el valor máximo del ABB (último nodo a la derecha)
    public int getMax() {
        return getMax(raiz);
    }

    private int getMax(Node node) {
        if (node.getRight() == null) {
            return node.getValue();
        }
        return getMax(node.getRight());
    }

    // Devuelve el valor mínimo del ABB (último nodo a la izquierda)
    public int getMin() {
        return getMin(raiz);
    }

    private int getMin(Node node) {
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
    public int countLeaves() {
        return countLeaves(raiz);
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }

    // Cuenta cuántos nodos internos (no hoja) hay en el árbol
    public int countInternalNodes() {
        return countInternalNodes(raiz);
    }

    private int countInternalNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 0;
        }
        return 1 + countInternalNodes(node.getLeft()) + countInternalNodes(node.getRight());
    }

    // Devuelve true si algún nodo del arbol tiene el valor indicado
    public boolean contains(int value) {
        return contains(value, raiz);
    }

    private boolean contains(int value, Node node) {
        if (node == null) {
            return false;
        }
        if (value > node.getValue()) {
            return contains(value, node.getRight());
        }
        if (value < node.getValue()) {
            return contains(value, node.getLeft());
        }
        return true;
    }

    // Busca y retorna el nodo con el valor indicado
    public Node find(int value) {
        return find(value, raiz);
    }

    private Node find(int value, Node node) {
        if (node == null) {
            return null;
        }
        if (value < node.getValue()) {
            return find(value, node.getLeft());
        }
        if (value > node.getValue()) {
            return find(value, node.getRight());
        }
        return node; // valor encontrado
    }

}
