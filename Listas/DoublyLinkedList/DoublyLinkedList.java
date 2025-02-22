package DoublyLinkedList;

public class DoublyLinkedList {
    Node first;
    Node last;
    int size;

    DoublyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    // ADD METHODS

    public void add(int value) {
        addLast(value);
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (this.size == 0) {
            this.first = newNode;
            this.last = this.first;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
            first.getNext().setPrev(first);
        }
        this.size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
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

    public void addAtIndex(int index, int value) {
        Node newNode = new Node(value);
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
        Node temp = first;
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

    public void remove() {

    }

    public void removeFirst() {
        if (this.size == 0) {
            throw new RuntimeException("List is empty");
        }
        if (this.size == 1) {
            this.first = null;
            this.last = null;
            this.size = 0;
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
            this.size = 0;
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

        Node temp = first;
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

    // PRINT

    public void display() {
        Node temp = first;
        while (temp != null) {
            System.out.println(" " + temp.getValue() + " ");
            temp = temp.getNext();
        }
    }

    public void displayReverse() {
        Node temp = last;
        while (temp != null) {
            System.out.println(" " + temp.getValue() + " ");
            temp = temp.getPrev();
        }
    }

}