package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
        ad1.addLast("a");
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());
        ad1.addFirst("b");
        assertEquals(2, ad1.size());
        ad1.addFirst("c");
        assertEquals(3, ad1.size());
        ad1.addLast("d");
        assertEquals(4, ad1.size());
        ad1.addFirst("e");
        assertEquals(5, ad1.size());
        ad1.addFirst("f");
        assertEquals(6, ad1.size());
        ad1.addLast("g");
        assertEquals(7, ad1.size());
        ad1.addLast("h");
        assertEquals(8, ad1.size());
    }
    @Test
    public void removeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        assertTrue("A newly initialized ArrayDeque should be empty", ad1.isEmpty());
        ad1.addLast("a");
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

//        assertEquals(ad1.removeFirst(),"a");
//        assertTrue("ad1 should be empty", ad1.isEmpty());

        ad1.addFirst("b");
        ad1.addFirst("c");

        assertEquals(ad1.removeLast(),"a");
        assertEquals(ad1.removeLast(),"b");
        assertEquals(ad1.removeLast(),"c");
        assertTrue("ad1 should be empty", ad1.isEmpty());
    }

    @Test
    public void getTest(){
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        ad1.addFirst("a");
        ad1.addLast("b");
        ad1.addLast("c");
        ad1.addLast("d");
       assertEquals(ad1.get(0), "a");
    }
}
