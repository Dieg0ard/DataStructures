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

    public int size(Node node){
        if(node == null){
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
}
