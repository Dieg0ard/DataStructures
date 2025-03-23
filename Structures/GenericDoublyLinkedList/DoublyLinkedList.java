package GenericDoublyLinkedList;

public class DoublyLinkedList<E extends Comparable<E>> {

    // Attributes
    private Node<E> first;
    private Node<E> last;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    // Add Methods
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

    // Remove Methods
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

    // Getters
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Print Methods
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

    // Sorting Methods
    public void sort() {
        if (size < 2)
            return;
        first = mergeSort(first);

        // Update `last` reference
        last = first;
        while (last.getNext() != null) {
            last = last.getNext();
        }
    }

    private Node<E> mergeSort(Node<E> head) {
        if (head == null || head.getNext() == null)
            return head;

        Node<E> middle = getMiddle(head);
        Node<E> secondHalf = middle.getNext();
        middle.setNext(null);
        if (secondHalf != null)
            secondHalf.setPrev(null);

        Node<E> left = mergeSort(head);
        Node<E> right = mergeSort(secondHalf);

        return merge(left, right);
    }

    private Node<E> getMiddle(Node<E> head) {
        if (head == null)
            return null;

        Node<E> slow = head, fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private Node<E> merge(Node<E> left, Node<E> right) {
        Node<E> dummy = new Node<>(null); // Auxiliary node
        Node<E> current = dummy;

        while (left != null && right != null) {
            if (left.getValue().compareTo(right.getValue()) <= 0) {
                current.setNext(left);
                left.setPrev(current);
                left = left.getNext();
            } else {
                current.setNext(right);
                right.setPrev(current);
                right = right.getNext();
            }
            current = current.getNext();
        }

        if (left != null) {
            current.setNext(left);
            left.setPrev(current);
        }
        if (right != null) {
            current.setNext(right);
            right.setPrev(current);
        }

        dummy.getNext().setPrev(null);
        return dummy.getNext();
    }
}
