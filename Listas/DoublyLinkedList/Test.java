package DoublyLinkedList;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList lista = new DoublyLinkedList();

        lista.addFirst(15);
        lista.addLast(51);
        lista.addAtIndex(1, 66);
        lista.display();
    }
}
