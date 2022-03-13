package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> bList = new BuggyAList<>();
        AListNoResizing<Integer> aList = new AListNoResizing<>();
        int[] three = {4,5,6};
        for (int i = 0; i < three.length; i++) {
            bList.addLast(three[i]);
            aList.addLast(three[i]);
        }

        assertEquals(bList.size(), aList.size());
        assertEquals(bList.removeLast(), aList.removeLast());
        assertEquals(bList.removeLast(), aList.removeLast());
        assertEquals(bList.removeLast(), aList.removeLast());
    }
}
