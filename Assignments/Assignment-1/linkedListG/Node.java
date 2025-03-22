package linkedListG;


public class Node<E> {

    private E value;
    private Node<E> next;

    Node(){

    }

    Node(E value){
        this.value = value;
        this.next = null;
    }

    public E getValue(){
        return this.value;
    }

    public  Node<E> getNext(){
        return this.next;
    }

    public void setNext(Node<E> node){
        this.next = node;
    }

    public void setValue(E value){
        this.value = value;
    }

    
    
}
