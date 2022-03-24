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

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bList = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4); // [0,2)
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bList.addLast(randVal);
                assertEquals(bList.size(), L.size());
            } else if (operationNumber == 1) {
                // size
//                int size = L.size();
//                int bsize = bList.size();
                assertEquals(bList.size(), L.size());
            } else {
                if(L.size()>0 && bList.size() >0){
                    if (operationNumber == 2) {
                        // getLast
                        int last = L.getLast();
                        int blast = bList.getLast();
                        assertEquals(bList.getLast(), L.getLast());
                    }else if (operationNumber == 3) {
                        // removeLast
//                        int removedLast = L.removeLast();
//                        int removedLastb = bList.removeLast();
                        assertEquals(bList.removeLast(), L.removeLast());
                    }
                }
            }
        }
    }
}
