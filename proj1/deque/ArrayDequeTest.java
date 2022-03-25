package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addFirstTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
        ad1.addFirst("a");
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());
        ad1.addFirst("b");
        assertEquals(2, ad1.size());
        ad1.addFirst("c");
        assertEquals(3, ad1.size());
        ad1.addFirst("d");
        assertEquals(4, ad1.size());
        ad1.addLast("e");
        assertEquals(5, ad1.size());
        ad1.addLast("f");
        assertEquals(6, ad1.size());
        ad1.addLast("g");
        assertEquals(7, ad1.size());
        ad1.addLast("h");
        assertEquals(8, ad1.size());
    }
}
