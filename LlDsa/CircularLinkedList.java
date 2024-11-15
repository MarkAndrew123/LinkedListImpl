public class CircularLinkedList<E> {
    

        // Nested Node class representing each node in the list
        private static class Node<E> {
            private E element;         // The data or value that this node stores
            private Node<E> next;      // Reference to the next node in the list
    
            // Constructor for Node: initializes the element and next reference
            public Node(E element, Node<E> next) {
                this.element = element;
                this.next = next;
            }
    
            // Getter for the element in the node
            public E getElement() {
                return element;
            }
    
            // Getter for the next node reference
            public Node<E> getNext() {
                return next;
            }
    
            // Setter for the next node reference
            public void setNext(Node<E> next) {
                this.next = next;
            }
        }
    
        // Instance variables of the CircularlyLinkedList
        private Node<E> tail = null; // Pointer to the tail node of the list
        private int size = 0;        // Tracks the number of nodes in the list
    
        // Constructor: initializes an empty circularly linked list
        public CircularlyLinkedList() { }
    
        // Accessor method: returns the current size of the list
        public int size() {
            return size;
        }
    
        // Accessor method: checks if the list is empty
        public boolean isEmpty() {
            return size == 0;
        }
    
        // Returns (but does not remove) the first element of the list
        public E first() {
            if (isEmpty()) return null;               // If list is empty, return null
            return tail.getNext().getElement();       // The first element is after the tail
        }
    
        // Returns (but does not remove) the last element of the list
        public E last() {
            if (isEmpty()) return null;               // If list is empty, return null
            return tail.getElement();                 // The last element is stored in the tail
        }
    
        // Rotates the first element to the back of the list
        public void rotate() {
            if (tail != null)                         // If list is non-empty
                tail = tail.getNext();                // Move tail to the next node
        }
    
        // Adds an element to the front of the list
        public void addFirst(E e) {
            if (size == 0) {                          // Case: list is initially empty
                tail = new Node<>(e, null);           // Create a new node that points to itself
                tail.setNext(tail);                   // Circular link to itself
            } else {                                  // Case: list is non-empty
                Node<E> newest = new Node<>(e, tail.getNext()); // New node points to the head
                tail.setNext(newest);                 // Tail now points to this new node
            }
            size++;                                   // Increase the size of the list
        }
    
        // Adds an element to the end of the list
        public void addLast(E e) {
            addFirst(e);                              // Insert new element at the front
            tail = tail.getNext();                    // Update tail to the new last element
        }
    
        // Removes and returns the first element of the list
        public E removeFirst() {
            if (isEmpty()) return null;               // If list is empty, nothing to remove
            Node<E> head = tail.getNext();            // Head is the node after the tail
            if (head == tail) {                       // Case: only one node in the list
                tail = null;                          // List becomes empty
            } else {
                tail.setNext(head.getNext());         // Tail skips the old head
            }
            size--;                                   // Decrease the size of the list
            return head.getElement();                 // Return the removed element
        }
    
    
    
}
