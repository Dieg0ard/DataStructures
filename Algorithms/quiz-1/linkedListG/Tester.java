package linkedListG;

public class Tester {
    public static void main (String[] args){

        LinkedList<Integer> list = new LinkedList<Integer>();

        // Test addBegining
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("List after addBegining(30), addBegining(20), addBegining(10):");
        list.printList(); // Expected: 30 20 10
        System.out.println("Size: " + list.getSize()); // Expected: 3

        // Test addLast
        list.addLast(40);
        list.addLast(50);
        System.out.println("List after addLast(40), addLast(50):");
        list.printList(); // Expected: 30 20 10 40 50
        System.out.println("Size: " + list.getSize()); // Expected: 5

        // Test addByindex
        list.addByindex(2, 25);
        System.out.println("List after addByindex(2, 25):");
        list.printList(); // Expected: 30 20 25 10 40 50
        System.out.println("Size: " + list.getSize()); // Expected: 6

        // Test addByindex edge cases
        list.addByindex(0, 100); // Should work like addBegining
        System.out.println("List after addByindex(0, 100):");
        list.printList(); // Expected: 100 30 20 25 10 40 50

        list.addByindex(list.getSize(), 200); // Should work like addLast
        System.out.println("List after addByindex(size, 200):");
        list.printList(); // Expected: 100 30 20 25 10 40 50 200

        // Test contains
        System.out.println("List contains 25: " + list.contains(25)); // Expected: true
        System.out.println("List contains 100: " + list.contains(100)); // Expected: true
        System.out.println("List contains 999: " + list.contains(999)); // Expected: false

        // Test get
        System.out.println("Element at index 3: " + list.get(3)); // Expected: 25
        System.out.println("Element at index 0: " + list.get(0)); // Expected: 100

        // Test indexOf
        System.out.println("Index of 25: " + list.indexOf(25)); // Expected: 3
        System.out.println("Index of 999: " + list.indexOf(999)); // Expected: -1

        // Test deleteByIndex
        list.deleteByIndex(2);
        System.out.println("List after deleteByIndex(2):");
        list.printList(); // Expected: 100 30 25 10 40 50 200
        System.out.println("Size: " + list.getSize()); // Expected: 7

        // Test deleteFirst
        list.deleteFirst();
        System.out.println("List after deleteFirst():");
        list.printList(); // Expected: 30 25 10 40 50 200
        System.out.println("Size: " + list.getSize()); // Expected: 6

        // Test deleteLast
        list.deleteLast();
        System.out.println("List after deleteLast():");
        list.printList(); // Expected: 30 25 10 40 50
        System.out.println("Size: " + list.getSize()); // Expected: 5

        // Test deleteFirst on a single-element list
        LinkedList<Integer> singleElementList = new LinkedList<Integer>();
        singleElementList.addBeginning(500);
        singleElementList.deleteFirst();
        System.out.println("List after deleteFirst() on single-element list:");
        singleElementList.printList(); // Expected: (empty)
        System.out.println("Size: " + singleElementList.getSize()); // Expected: 0

        // Test deleteLast on a single-element list
        singleElementList.addBeginning(600);
        singleElementList.deleteLast();
        System.out.println("List after deleteLast() on single-element list:");
        singleElementList.printList(); // Expected: (empty)
        System.out.println("Size: " + singleElementList.getSize()); // Expected: 0

        // Test getSize
        System.out.println("Current size of list: " + list.getSize()); // Expected: 5

        // Test getFirstNode
        System.out.println("First node value: " + list.nodeGetFirstValue()); // Expected: 30

        // Test nodeGetLastValue
        System.out.println("Last node value: " + list.nodeGetLastValue()); // Expected: 50
        list.printList();

        // Test clear
        list.clear();
        System.out.println("List after clear():");
        list.printList(); // Expected: (empty)
        System.out.println("Size after clear: " + list.getSize()); // Expected: 0

     
    }
    
}
