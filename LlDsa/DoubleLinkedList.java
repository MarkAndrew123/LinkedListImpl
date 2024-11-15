import org.w3c.dom.Node;

public class DoubleLinkedList<E> {
    private static class Node<E> {

     private E element;
     private Node<E> prev;
     private Node<E> next;

  public Node(E e, Node<E> p, Node<E> n ){
    this.element = e;
    this.prev = p;
    this.next =  n;
  }
  public E getElement(){
   return element;
  }
  public Node<E> getPrevious(){
    return prev;
  }
  public Node<E> getNext() {
    return next;
  }
  public void setPrev(Node<E> p) {
    this.prev = p;
  }
  public void setNext(Node<E> n){
  this.next = n;
  }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0; 

    public DoubleLinkedList(){
        Node<E> header = new Node<>(null, null, null);
        Node<E> trailer = new Node<>(null, header, null);

    }
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty())  return null;
        return header.getPrevious().getElement();
            
        
    }
    public E last(){
        if (isEmpty())  return null;
        return trailer.getNext().getElement();
            
        
    }
    public void  addFirst( E e){
     addBetween(e, header, header.getNext());
    }
    public  void addLast( E e){
        addBetween(e, trailer.getPrevious(), trailer);

    }
    public E removeFirst(){
        if (isEmpty()) {
            return null;
        }
        return remove((header).getNext());
    }
    public E removeLast(){
        if (isEmpty()) {
            return null;
            
        }
        return remove((trailer).getPrevious());
    }
        private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
            Node<E> newest = new Node<>(e, predecessor, successor); 
            predecessor.setNext(newest);      
            successor.setPrev(newest);        
            size++;  
    
    }
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrevious();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    
    
    }
    
   