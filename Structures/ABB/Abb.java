package ABB;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    // Limpia el contenido del arbol
    public void clear() {
        raiz = null;
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

    public int treeSumatory() {
        return treeSumatory(raiz);
    }

    private int treeSumatory(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getValue() + treeSumatory(node.getLeft()) + treeSumatory(node.getRight());
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

    public int countSingleChildNodes() {
        return countSingleChildNodes(raiz);
    }

    private int countSingleChildNodes(Node node) {
        if (node == null) {
            return 0;
        }

        // Si tiene exactamente un hijo
        if ((node.getLeft() == null && node.getRight() != null)
                || (node.getLeft() != null && node.getRight() == null)) {
            return 1 + countSingleChildNodes(node.getLeft()) + countSingleChildNodes(node.getRight());
        }

        // Si tiene ambos hijos o ninguno
        return countSingleChildNodes(node.getLeft()) + countSingleChildNodes(node.getRight());
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

    public boolean isSymmetric() {
        if (raiz == null) {
            return true;
        }
        return isSymmetric(raiz.getLeft(), raiz.getRight());
    }

    private boolean isSymmetric(Node nodeLeft, Node nodeRight) {
        if (nodeLeft == null && nodeRight == null) {
            return true;
        }

        if (nodeLeft == null || nodeRight == null) {
            return false;
        }

        return nodeLeft.getValue() == nodeRight.getValue()
                && isSymmetric(nodeLeft.getLeft(), nodeRight.getRight())
                && isSymmetric(nodeLeft.getRight(), nodeRight.getLeft());
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

    public boolean sameStructure(Node other) {
        return sameStructure(this.getRaiz(), other);
    }

    private boolean sameStructure(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null ^ right == null) {
            return false;
        }
        return (left.getValue() == right.getValue())
                && (sameStructure(left.getLeft(), right.getLeft()))
                && (sameStructure(left.getRight(), right.getRight()));
    }

    public int summatoryInRange(int min, int max) {
        return summatoryInRange(min, max, this.getRaiz());
    }

    private int summatoryInRange(int min, int max, Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getValue() < min) {
            return summatoryInRange(min, max, node.getRight());
        }

        if (node.getValue() > max) {
            return summatoryInRange(min, max, node.getLeft());
        }

        return node.getValue() + summatoryInRange(min, max, node.getLeft())
                + summatoryInRange(min, max, node.getRight());
    }

    public int countLeavesInRange(int min, int max) {
        return countLeavesInRange(min, max, this.getRaiz());
    }

    private int countLeavesInRange(int min, int max, Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getValue() < min) {
            return countLeavesInRange(min, max, node.getRight());
        }

        if (node.getValue() > max) {
            return countLeavesInRange(min, max, node.getLeft());
        }
        if (isLeaf(node)) {
            return 1;
        }

        return countLeavesInRange(min, max, node.getLeft()) + countLeavesInRange(min, max, node.getRight());
    }

    // Devuelve la altura del arbol
    public int getHeight() {
        return getHeight(raiz);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    public List<Integer> toListInOrder() {
        List<Integer> result = new ArrayList<>();
        toListInOrder(raiz, result);
        return result;
    }

    private void toListInOrder(Node node, List<Integer> result) {
        if (node != null) {
            toListInOrder(node.getLeft(), result);
            result.add(node.getValue());
            toListInOrder(node.getRight(), result);
        }
    }

    public Stack<Integer> toStackInOrder() {
        Stack<Integer> stack = new Stack<>();
        toStackInOrder(raiz, stack);
        return stack;
    }

    private void toStackInOrder(Node node, Stack<Integer> stack) {
        if (node != null) {
            toStackInOrder(node.getRight(), stack); // Importante: primero el derecho
            stack.push(node.getValue()); // para que el menor quede arriba
            toStackInOrder(node.getLeft(), stack);
        }
    }

    public Queue<Integer> toQueueInOrder() {
        Queue<Integer> queue = new LinkedList<>();
        toQueueInOrder(raiz, queue);
        return queue;
    }

    private void toQueueInOrder(Node node, Queue<Integer> queue) {
        if (node != null) {
            toQueueInOrder(node.getLeft(), queue);
            queue.add(node.getValue());
            toQueueInOrder(node.getRight(), queue);
        }
    }

    public int depth(int value) {
    return depth(raiz, value, 0);
}

private int depth(Node node, int value, int nivel) {
    if (node == null) {
        return -1;
    }
    if (node.getValue() == value) {
        return nivel;
    } else if (value < node.getValue()) {
        return depth(node.getLeft(), value, nivel + 1);
    } else {
        return depth(node.getRight(), value, nivel + 1);
    }
}

public List<Integer> pathTo(int value) {
    List<Integer> path = new ArrayList<>();
    if (pathTo(raiz, value, path)) {
        return path;
    } else {
        return new ArrayList<>(); // valor no encontrado
    }
}

private boolean pathTo(Node node, int value, List<Integer> path) {
    if (node == null) {
        return false;
    }

    path.add(node.getValue());

    if (node.getValue() == value) {
        return true;
    }

    if (value < node.getValue()) {
        if (pathTo(node.getLeft(), value, path)) return true;
    } else {
        if (pathTo(node.getRight(), value, path)) return true;
    }

    path.remove(path.size() - 1); // backtrack si no se encuentra en este camino
    return false;
}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(raiz, sb);
        return sb.toString().trim();
    }

    private void toString(Node node, StringBuilder sb) {
        if (node != null) {
            toString(node.getLeft(), sb);
            sb.append(node.getValue()).append(" ");
            toString(node.getRight(), sb);
        }
    }

}
