package deque;

public class LinkedListDeque<T> {

    private class StuffNode{
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
    public LinkedListDeque(){
        sentinel = new StuffNode(null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size =0;
    }

    /** Create a deque with an item of type T as the first item*/
    public LinkedListDeque(T item){
        sentinel=new StuffNode(null,null);
        sentinel.next = new StuffNode(item, sentinel);
        sentinel.next.prev = sentinel;
        sentinel.prev = sentinel.next;
        size =1;
    }

    /** Add an item of type T to the front of the deque*/
    public void addFirst(T item){
        sentinel.next=new StuffNode(item, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /** Add an item of type T to the back of the deque*/

    public void addLast(T item){
        sentinel.prev.next = new StuffNode(item, sentinel);
        sentinel.prev.next.prev = sentinel.prev;
        sentinel.prev = sentinel.prev.next;
        size++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }

    /**  Prints the items in the deque from first to last*/
    public void printDeque(){
        for(StuffNode p = sentinel.next; p!= sentinel ; p=p.next) {
            System.out.print(p.item+" ");
        }
        System.out.println();
    }



}
