package DoublyLinkedList;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList lista = new DoublyLinkedList();

        lista.addFirst(15);
        lista.addFirst(18);
        lista.addFirst(19);
        lista.addFirst(1541);
        lista.addFirst(0);
        lista.addFirst(-15);
        lista.addLast(-30);
        lista.displayReverse();
    }
}
