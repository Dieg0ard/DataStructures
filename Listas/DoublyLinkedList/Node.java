package DoublyLinkedList;

public class Node {

    private int value;
    private Node next;
    private Node prev;

    //CONSTRUCTORS
    Node(){

    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    Node(int value){
        this.value = value;
        this.next = null;
    }

    //SETTERS
    public void setNext(Node node){
        this.next = node;
    }

    public void setPrev(Node node){
        this.prev = node;
    }

    public void setValue(int value){
        this.value = value;
    }


    //GETTERS
    public int getValue(){
        return this.value;
    }

    public  Node getNext(){
        return this.next;
    }

    public Node getPrev(){
        return this.prev;
    }




    
    
}