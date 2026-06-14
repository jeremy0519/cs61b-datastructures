package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomizedNoResizingTest {
    @Test
    public void randomizedNoResizingTest() {
        ArrayDeque<Integer> arrDeque = new ArrayDeque<>();
        LinkedListDeque<Integer> llDeque = new LinkedListDeque<>();

        int N = 9999;
        for (int i = 0; i < N; i += 1) {
            // Randomly choose an operation from 0 to 6
            int operationNumber = StdRandom.uniform(0, 7);
            if (operationNumber == 0) {
                // addFirst
                if (llDeque.size() < 8) {
                    int randVal = StdRandom.uniform(0, 100);
                    arrDeque.addFirst(randVal);
                    llDeque.addFirst(randVal);
                }
            } else if (operationNumber == 1) {
                // addLast
                if (llDeque.size() < 8) {
                    int randVal = StdRandom.uniform(0, 100);
                    arrDeque.addLast(randVal);
                    llDeque.addLast(randVal);
                }
            } else if (operationNumber == 2) {
                // size
                assertEquals(arrDeque.size(), llDeque.size());
            } else if (operationNumber == 3) {
                // printDeque
                System.out.println("----- 请人工比对printDeque是否一致 -----");
                arrDeque.printDeque();
                llDeque.printDeque();
            } else if (operationNumber == 4) {
                // removeFirst
                if (!llDeque.isEmpty()) {
                    assertEquals(arrDeque.removeFirst(), llDeque.removeFirst());
                }
            } else if (operationNumber == 5) {
                // removeLast
                if (!llDeque.isEmpty()) {
                    assertEquals(arrDeque.removeLast(), llDeque.removeLast());
                }
            } else if (operationNumber == 6) {
                // get
                if (!llDeque.isEmpty()) {
                    int idx = StdRandom.uniform(0, llDeque.size());
                    assertEquals(llDeque.get(idx), arrDeque.get(idx));
                }
            }
        }
    }
}
