package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Create an empty deque*/
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size=0;
        nextFirst=0;
        nextLast=nextFirst+1;
    }
    /** Return the number of items in the deque*/
    public int size(){
        return size;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        return size==0;
    }

    /** Returns true if deque is full, false otherwise.*/
    public boolean isFull(){
        return size==items.length;
    }
    /** Add an item of type T to the front of the deque.*/
    public void addFirst(T item){
        items[nextFirst]=item;
        size++;
        if (nextFirst<items.length&&nextFirst>0) {
            nextFirst--;
        }else if(nextFirst==0){
            nextFirst=items.length-1;
        }

    }

    /** Add an item of type T to the back of the deque*/
    public void addLast(T item){
        items[nextLast]=item;
        size++;
        if (nextLast<items.length&&nextLast>0) {
            nextLast++;
        }else if(nextLast==items.length-1){
            nextLast=0;
        }
    }
   /** Removes and returns the item at the front of the deque.*/
   public T removeFirst(){
       if (size==0) {
           return null;
       }
       if (nextFirst== items.length-1) {
           nextFirst=0;
       }else{
           nextFirst++;
       }
       T removedFirst = items[nextFirst];
       items[nextFirst]=null;
       size--;
       return removedFirst;
   }
   /** Removes and returns the item at the back of the deque.*/
   public T removeLast(){
       if (size==0) {
           return null;
       }
       if (nextLast== 0) {
           nextLast=items.length-1;
       }else{
           nextLast--;
       }
       T removedLast = items[nextLast];
       items[nextLast]=null;
       size--;
       return removedLast;
   }
   /**  Gets the item at the given index*/



}

