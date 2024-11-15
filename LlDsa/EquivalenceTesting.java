@Override
public boolean equals(Object o) {
    // Step 1: Check if the input object is null
    if (o == null) return false;

    // Step 2: Check if the object belongs to the same class
    if (getClass() != o.getClass()) return false;

    // Step 3: Cast the object to a SinglyLinkedList
    SinglyLinkedList<?  > other = (SinglyLinkedList<?>) o;

    // Step 4: Check if the sizes of the two lists are different
    if (this.size != other.size) return false;

    // Step 5: Traverse both lists and compare their elements
    Node<?> walkA = this.head;       // Start with the head of this list
    Node<?> walkB = other.head;     // Start with the head of the other list

    while (walkA != null) {         // Continue until we reach the end of the lists
        if (!walkA.getElement().equals(walkB.getElement())) {
            return false;           // If elements mismatch, the lists are not equal
        }
        walkA = walkA.getNext();    // Move to the next node in this list
        walkB = walkB.getNext();    // Move to the next node in the other list
    }

    return true;                    // Lists are equal if all elements matched
}
