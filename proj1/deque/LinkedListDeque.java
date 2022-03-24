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

    /** Creates a deque with item as the first item*/
    public LinkedListDeque(T item){
        sentinel=new StuffNode(null,null);
        sentinel.next = new StuffNode(item, sentinel);
        sentinel.next.prev = sentinel;
        sentinel.prev = sentinel.next;
        size =1;
    }

    /** Add item to the front of the deque*/
    public void addFirst(T item){
        sentinel.next=new StuffNode(item, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        size++;
    }







}
