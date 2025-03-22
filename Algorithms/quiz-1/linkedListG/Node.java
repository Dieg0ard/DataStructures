package linkedListG;

public class Node<E> {

    // ======= ATRIBUTOS =======
    private E value;
    private Node<E> next;

    // ======= CONSTRUCTORES =======
    public Node() {
    }

    public Node(E value) {
        this.value = value;
        this.next = null;
    }

    // ======= MÉTODOS GETTERS =======
    public E getValue() {
        return this.value;
    }

    public Node<E> getNext() {
        return this.next;
    }

    // ======= MÉTODOS SETTERS =======
    public void setNext(Node<E> node) {
        this.next = node;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
