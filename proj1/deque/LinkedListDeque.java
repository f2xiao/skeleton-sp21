package deque;

public class LinkedListDeque<T> {

    private class StuffNode {
        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(T x, StuffNode n){
            item = x;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    /** Create an empty deque*/
    public LinkedListDeque() {
        sentinel = new StuffNode(null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Create a deque with an item of type T as the first item*/
    public LinkedListDeque(T item) {
        sentinel = new StuffNode(null,null);
        sentinel.next = new StuffNode(item, sentinel);
        sentinel.next.prev = sentinel;
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Add an item of type T to the front of the deque*/
    public void addFirst(T item) {
        sentinel.next=new StuffNode(item, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /** Add an item of type T to the back of the deque*/
    public void addLast(T item) {
        sentinel.prev.next = new StuffNode(item, sentinel);
        sentinel.prev.next.prev = sentinel.prev;
        sentinel.prev = sentinel.prev.next;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    /**  Prints the items in the deque from first to last*/
    public void printDeque() {
        for (StuffNode p = sentinel.next; p!= sentinel ; p=p.next) {
            System.out.print(p.item+" ");
        }
        System.out.println();
    }
    /** Removes and returns the item at the front of the deque*/
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removedFirst = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return removedFirst;
    }

    /** Removes and returns the item at the back of the deque*/

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removedLast = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return removedLast;
    }

    /** Gets the item at the given index, using loop*/
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        if (index == size-1) {
            return sentinel.prev.item;
        }
        StuffNode p = sentinel.next;
        for (int i = index; i >0 ; i--) {
            p=p.next;
        }
        return p.item;
    }
    /** Helper function for getRecursive, get the item at given index and starts at node p*/
    private T getRecursive(int i, StuffNode p) {
        if (i == 0) {
            return p.item;
        }
        return getRecursive(i - 1, p.next);
    }


    /** Gets the item at the given index, using recursion*/
    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

}
