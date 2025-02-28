package GenericDoublyLinkedList;

public class DoublyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    // ADD METHODS

    public void add(E value) {
        addLast(value);
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        if (this.size == 0) {
            this.first = newNode;
            this.last = this.first;
        } else {
            newNode.setNext(this.first);
            this.first.setPrev(newNode);
            this.first = newNode;
        }
        this.size++;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);
        if (this.size == 0) {
            this.first = newNode;
            this.last = this.first;
        } else {
            this.last.setNext(newNode);
            newNode.setPrev(this.last);
            this.last = newNode;
        }
        this.size++;
    }

    public void addAtIndex(int index, E value) {
        if (index < 0 || index > this.size) {
            throw new RuntimeException("Index " + index + " is out of bounds");
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node<E> newNode = new Node<>(value);
        Node<E> temp = first;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        temp.getNext().setPrev(newNode);
        temp.setNext(newNode);
        size++;
    }

    // REMOVE METHODS

    public void removeFirst() {
        if (this.size == 0) {
            throw new RuntimeException("List is empty");
        }
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
            this.first.setPrev(null);
        }
        size--;
    }

    public void removeLast() {
        if (this.size == 0) {
            throw new RuntimeException("List is empty");
        }
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.last = this.last.getPrev();
            this.last.setNext(null);
        }
        size--;
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new RuntimeException("Index " + index + " is out of bounds");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        Node<E> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        size--;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    // GETTERS

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // PRINT METHODS

    public void display() {
        Node<E> temp = first;
        while (temp != null) {
            System.out.println(" " + temp.getValue() + " ");
            temp = temp.getNext();
        }
    }

    public void displayReverse() {
        Node<E> temp = last;
        while (temp != null) {
            System.out.println(" " + temp.getValue() + " ");
            temp = temp.getPrev();
        }
    }
}
