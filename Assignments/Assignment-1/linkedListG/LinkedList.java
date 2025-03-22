package linkedListG;

public class LinkedList<E> {

  public Node<E> head;
  public Node<E> tail;
  private int size = 0;

  public LinkedList() {

  }

  public void addBeginning(E value) {
    Node<E> newNode = new Node<E>(value);
    if (this.size == 0) {
      this.head = newNode;
      this.tail = this.head;

    } else {
      newNode.setNext(this.head);
      this.head = newNode;
    }
    this.size++;
  }

  public void addByindex(int index, E value) {
    if (index == 0) {
      this.addBeginning(value);
      return;
    }
    if (index == this.size - 1) {
      this.addLast(value);
      return;
    }
    Node<E> currentNode = this.head;
    Node<E> newNode = new Node<E>(value);
    int i = 0;
    // index -1 para que salga antes, cuando el nodo permite hacer la modificacion
    while (currentNode != null && i != index - 1) {
      currentNode = currentNode.getNext();
      i++;
    }
    newNode.setNext(currentNode.getNext());// le asigna como siguiente el que ocupaba su posicion
    currentNode.setNext(newNode);// agrega el nuevo nodo en la posicion
    this.size++;
  }

  public void addLast(E value) {
    Node<E> newNode = new Node<E>(value);
    if (this.size == 0) {
      this.head = newNode;
      this.tail = this.head;
      this.size++;
    } else {
      this.tail.setNext(newNode);
      this.tail = newNode;
      this.size++;
    }
  }

  public void clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public boolean contains(E value) {
    boolean exists = false;
    Node<E> currentNode = this.head;
    while (currentNode != null && exists == false) {
      if (currentNode.getValue().equals(value)) {
        exists = true;
      }
      currentNode = currentNode.getNext();
    }
    return exists;
  }

  // we use the index like in arrays
  public void deleteByIndex(int index) {
    if (index < this.size) {
      int reference = index - 1;
      int i = 0;
      if (index == 0) {
        this.deleteFirst();
      } else {
        if (index == this.size - 1) {
          this.deleteLast();
        } else {
          Node<E> currentNode = this.head;
          while (i != reference && currentNode != null) {
            currentNode = currentNode.getNext();
            i++;
          }
          Node<E> temp = currentNode.getNext();
          currentNode.setNext(currentNode.getNext().getNext());
          temp.setNext(null);
          this.size--;
        }
      }
    }

  }

  public void deleteFirst() {
    if (this.size == 1) {
      this.head = null;
      this.tail = null;
      this.size--;
    } else {
      Node<E> temp = this.head;
      this.head = this.head.getNext();
      temp.setNext(null);
      this.size--;
    }

  }

  public void deleteLast() {
    if (this.size == 1) {
      this.head = null;
      this.tail = null;
      this.size--;
    } else {
      Node<E> currentNode = this.head;
      while (currentNode.getNext().getNext() != null) {
        currentNode = currentNode.getNext();
      }
      currentNode.setNext(null);
      this.tail = currentNode;
      this.size--;
    }
  }

  // returns the element at the intex
  public E get(int index) {
    Node<E> currentNode = this.head;
    int i = 0;
    while (currentNode != null && i != index) {
      currentNode = currentNode.getNext();
      i++;
    }
    return currentNode.getValue();
  }

  public Node<E> getNode(int index) {
    Node<E> currentNode = this.head;
    int i = 0;
    while (currentNode != null && i != index) {
      currentNode = currentNode.getNext();
      i++;
    }
    return currentNode;
  }

  public int indexOf(E value) {
    boolean exists = false;
    Node<E> currentNode = this.head;
    int i = 0;
    while (currentNode != null && exists == false) {
      if (currentNode.getValue().equals(value)) {
        exists = true;
      }
      currentNode = currentNode.getNext();
      i++;
    }
    if (exists == true) {
      return i - 1; // como la variable sale del ciclo luego de validar que existe
    } else {
      return -1;
    }
  }

  public void printList() {
    Node<E> currentNode = this.head;
    while (currentNode != null) {
      System.out.println(currentNode.getValue());
      currentNode = currentNode.getNext();
    }
  }

  // public void setHead(E node){
  //   this.head = (Node)node;
  // }


  public Node<E> getFirstNode() {
    return this.head;
  }

  public int getSize() {
    return this.size;
  }

  public E nodeGetFirstValue() {
    return this.head.getValue();
  }

  public E nodeGetLastValue() {
    return this.tail.getValue();
  }
}
