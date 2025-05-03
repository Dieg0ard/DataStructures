package ABB;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void add(int element) {
        if (element < value) {
            if (left == null) {
                left = new Node(element);
            } else {
                left.add(element);
            }
        } else {
            if (right == null) {
                right = new Node(element);
            } else {
                right.add(element);
            }
        }
    }

    @Override
    public String toString() {
        return value + "";
    }
}