package GenericDoublyLinkedList;

public class Node<E> {

    private E value;
    private Node<E> next;
    private Node<E> prev;

    // CONSTRUCTORS
    public Node() {
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public Node(E value) {
        this.value = value;
        this.next = null;
    }

    // SETTERS
    public void setNext(Node<E> node) {
        this.next = node;
    }

    public void setPrev(Node<E> node) {
        this.prev = node;
    }

    public void setValue(E value) {
        this.value = value;
    }

    // GETTERS
    public E getValue() {
        return this.value;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public Node<E> getPrev() {
        return this.prev;
    }
}
