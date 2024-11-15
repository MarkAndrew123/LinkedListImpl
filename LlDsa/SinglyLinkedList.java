public class SinglyLinkedList<E> {
    // Nested Node class: Represents a node in the linked list
    private static class Node<E> {
        private E element;  // The data or value that the node stores
        private Node<E> next;  // A reference (or link) to the next node in the list

        // Constructor for the Node class
        public Node(E e, Node<E> n) {
            element = e;  // Set the data of the node to e
            next = n;  // Set the next node to n (could be null)
        }

        // Getter for the element in the node
        public E getElement() {
            return element;  // Return the data stored in the node
        }

        // Getter for the next node reference
        public Node<E> getNext() {
            return next;  // Return the reference to the next node
        }

        // Setter for the next node reference
        public void setNext(Node<E> n) {
            next = n;  // Update the reference to the next node
        }
    }

    // Instance variables for the SinglyLinkedList class
    private Node<E> head = null;  // Head of the list (or null if the list is empty)
    private Node<E> tail = null;  // Tail of the list (or null if the list is empty)
    private int size = 0;  // Keeps track of the number of elements in the list

    // Constructor for the SinglyLinkedList class
    public SinglyLinkedList() {
        // Initializes an empty list with head, tail as null, and size as 0
    }

    // Access methods
    public int size() {
        return size;  // Returns the current size (number of elements in the list)
    }

    public boolean isEmpty() {
        return size == 0;  // Checks if the list is empty (size is 0)
    }

    public E first() {
        if (isEmpty()) return null;  // If the list is empty, return null
        return head.getElement();  // Otherwise, return the element in the head node
    }

    public E last() {
        if (isEmpty()) return null;  // If the list is empty, return null
        return tail.getElement();  // Otherwise, return the element in the tail node
    }

    // Update methods
    public void addFirst(E e) {
        head = new Node<>(e, head);  // Create a new node with data e, and point it to the old head
        if (size == 0) {
            tail = head;  // Special case: if the list was empty, set the new node as the tail too
        }
        size++;  // Increment the size of the list
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);  // Create a new node to be added at the end
        if (isEmpty()) {
            head = newest;  // Special case: if the list is empty, set the new node as the head
        } else {
            tail.setNext(newest);  // Point the old tail's next reference to the new node
        }
        tail = newest;  // The new node becomes the tail
        size++;  // Increment the size of the list
    }

    public E removeFirst() {
        if (isEmpty()) return null;  // If the list is empty, nothing to remove
        E answer = head.getElement();  // Get the element from the head node
        head = head.getNext();  // Move the head to the next node in the list
        size--;  // Decrease the size of the list
        if (size == 0) {
            tail = null;  // If the list is empty, the tail should also be null
        }
        return answer;  // Return the removed element
    }
}

