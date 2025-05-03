package ABB;

public class Abb {
    private Node raiz;

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public void add(int elemento) {
        if (raiz == null) {
            raiz = new Node(elemento);

        } else {
            raiz.add(elemento);
        }
    }

    public void inorden(Node node) {
        if (node == null) {
        } else {
            inorden(node.getLeft());
            System.out.println("Dato: " + node.getValue());
            inorden(node.getRight());
        }
    }

    public void preorden(Node node) {
        if (node == null) {
        } else {
            preorden(node.getRight());
            System.out.println("Dato: " + node.getValue());
            preorden(node.getLeft());
        }

    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public int maximoPar(Node node) {
        int maxPar = Integer.MIN_VALUE;
        if (node == null) {
            return maxPar;
        }
        if (node.getValue() % 2 == 0) {
            maxPar = Math.max(maxPar, node.getValue());
        }
        if (node.getLeft() != null) {
            maxPar = Math.max(maxPar, maximoPar(node.getLeft()));
        }
        if (node.getRight() != null) {
            maxPar = Math.max(maxPar, maximoPar(node.getRight()));
        }
        return maxPar;
    }

    public int getMax(Node node) {
        if (node.getRight() == null) {
            return node.getValue();
        }
        return getMax(node.getRight());
    }

    public int getMin(Node node) {
        if (node.getLeft() == null) {
            return node.getValue();
        }
        return getMin(node.getLeft());
    }

    public boolean isEmpty() {
        return getRaiz() == null;
    }

    public boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    public int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }

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
