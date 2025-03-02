package linkedListG;

public class LinkedList<E> {

  // ======= ATRIBUTOS =======
  public Node<E> head;
  public Node<E> tail;
  private int size = 0;

  // ======= CONSTRUCTOR =======
  public LinkedList() {
  }

  // ======= MÉTODOS PARA AGREGAR ELEMENTOS =======
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
    if (index == this.size) {
      this.addLast(value);
      return;
    }
    Node<E> currentNode = this.head;
    Node<E> newNode = new Node<E>(value);
    int i = 0;
    while (currentNode != null && i != index - 1) {
      currentNode = currentNode.getNext();
      i++;
    }
    newNode.setNext(currentNode.getNext());
    currentNode.setNext(newNode);
    this.size++;
  }

  public void addLast(E value) {
    Node<E> newNode = new Node<E>(value);
    if (this.size == 0) {
      this.head = newNode;
      this.tail = this.head;
    } else {
      this.tail.setNext(newNode);
      this.tail = newNode;
    }
    this.size++;
  }

  // ======= MÉTODO PARA LIMPIAR LA LISTA =======
  public void clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // ======= MÉTODOS PARA VERIFICAR Y OBTENER ELEMENTOS =======
  public boolean contains(E value) {
    Node<E> currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.getValue().equals(value)) {
        return true;
      }
      currentNode = currentNode.getNext();
    }
    return false;
  }

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
    Node<E> currentNode = this.head;
    int i = 0;
    while (currentNode != null) {
      if (currentNode.getValue().equals(value)) {
        return i;
      }
      currentNode = currentNode.getNext();
      i++;
    }
    return -1;
  }

  // ======= MÉTODOS PARA ELIMINAR ELEMENTOS =======
  public void deleteByIndex(int index) {
    if (index >= this.size) return;
    if (index == 0) {
      this.deleteFirst();
    } else if (index == this.size - 1) {
      this.deleteLast();
    } else {
      Node<E> currentNode = this.head;
      int i = 0;
      while (i != index - 1) {
        currentNode = currentNode.getNext();
        i++;
      }
      Node<E> temp = currentNode.getNext();
      currentNode.setNext(temp.getNext());
      temp.setNext(null);
      this.size--;
    }
  }

  public void deleteFirst() {
    if (this.size == 0) return;
    if (this.size == 1) {
      this.head = null;
      this.tail = null;
    } else {
      Node<E> temp = this.head;
      this.head = this.head.getNext();
      temp.setNext(null);
    }
    this.size--;
  }

  public void deleteLast() {
    if (this.size == 0) return;
    if (this.size == 1) {
      this.head = null;
      this.tail = null;
    } else {
      Node<E> currentNode = this.head;
      while (currentNode.getNext().getNext() != null) {
        currentNode = currentNode.getNext();
      }
      currentNode.setNext(null);
      this.tail = currentNode;
    }
    this.size--;
  }

  // ======= MÉTODOS UTILITARIOS =======
  public void printList() {
    Node<E> currentNode = this.head;
    while (currentNode != null) {
      System.out.println(currentNode.getValue());
      currentNode = currentNode.getNext();
    }
  }

  public int getSize() {
    return this.size;
  }

  public Node<E> getFirstNode() {
    return this.head;
  }

  public E nodeGetFirstValue() {
    return this.head.getValue();
  }

  public E nodeGetLastValue() {
    return this.tail.getValue();
  }
}
