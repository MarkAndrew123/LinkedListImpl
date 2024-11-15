// LinkedList Implementation in Java

public class LinkedList {

    // Node class to represent each element in the list
    private class Node {
        int element;  // Data stored in the node
        Node next;    // Reference to the next node

        // Node constructor
        public Node(int e) {
            element = e;
            next = null; // The next node is null when a node is created
        }
    }

    private Node head;  // The first node in the list
    private Node tail;  // The last node in the list
    private int size;   // Size of the list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Method to add an element to the front of the list
    public void addFirst(int e) {
        Node newest = new Node(e);  // Create a new node with the element
        if (head == null) {          // If the list is empty
            tail = newest;           // The tail is also the newest node
        }
        newest.next = head;          // Make the new node point to the current head
        head = newest;               // Set the new node as the head of the list
        size++;                      // Increment the size
    }

    // Method to add an element to the end of the list
    public void addLast(int e) {
        Node newest = new Node(e);  // Create a new node with the element
        if (tail == null) {          // If the list is empty
            head = newest;           // The head is also the newest node
        }
        newest.next = null;          // The new node's next is null
        if (tail != null) {          // If there is an existing tail
            tail.next = newest;      // Make the old tail point to the new node
        }
        tail = newest;               // Set the new node as the tail
        size++;                      // Increment the size
    }

    // Method to remove the first element of the list
    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.next;            // Move the head to the next node
        size--;                      // Decrement the size
        if (head == null) {          // If the list is now empty
            tail = null;             // Set the tail to null
        }
    }

    // Method to check the size of the list
    public int size() {
        return size;
    }

    // Method to print the elements of the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method for testing the linked list operations
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);  // Add 10 to the front
        list.addFirst(20);  // Add 20 to the front
        list.addLast(5);    // Add 5 to the end
        list.printList();   // Should print: 20 -> 10 -> 5 -> null
        list.removeFirst(); // Remove the first element (20)
        list.printList();   // Should print: 10 -> 5 -> null
    }
}
