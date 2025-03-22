package estructuras;

public class Stack<E> {
    private int size = 0;
    private Node<E> top;

    public Stack() {
    }

    public Stack(Node<E> top) {
        this.top = top;
    }

    public void push(E value) {
        Node<E> newNode = new Node<E>(value, this.top);
        this.top = newNode;
        this.size++;
    }

    public E pop() {
        if (this.top != null) {
            E value = this.top.getValue();
            this.top = this.top.getNext();
            this.size--;
            return value;
        }
        return null;
    }

    public Node<E> getTop() {
        return this.top;
    }

    public void setTop(Node<E> top) {
        this.top = top;
    }

    public int getSize() {
        return this.size;
    }

    public void printStack() {
        Node<E> currentNode = this.top;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
