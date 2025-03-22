package estructuras;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node() {

    }

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return this.value;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> node) {
        this.next = node;
    }

    public void setValue(E value) {
        this.value = value;
    }

}
