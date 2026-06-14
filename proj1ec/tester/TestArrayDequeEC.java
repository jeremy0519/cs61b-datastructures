package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void testArrayDequeEC() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String message = "";

        //noinspection InfiniteLoopStatement
        while (true) {
            // Randomly choose an operation from 0 to 6
            int operationNumber = StdRandom.uniform(0, 7);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                message += "addFirst(" + randVal + ")\n";
                sad.addFirst(randVal);
                ads.addFirst(randVal);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                message += "addLast(" + randVal + ")\n";
                sad.addLast(randVal);
                ads.addLast(randVal);
            } else if (operationNumber == 2) {
                // size
                message += "size()\n";
                assertEquals(message, sad.size(), ads.size());
            } else if (operationNumber == 3) {
                // isEmpty
                message += "isEmpty()\n";
                assertEquals(message, sad.isEmpty(), ads.isEmpty());
            } else if (operationNumber == 4) {
                // removeFirst
                if (!ads.isEmpty()) {
                    message += "removeFirst()\n";
                    assertEquals(message, sad.removeFirst(), ads.removeFirst());
                }
            } else if (operationNumber == 5) {
                // removeLast
                if (!ads.isEmpty()) {
                    message += "removeLast()\n";
                    assertEquals(message, sad.removeLast(), ads.removeLast());
                }
            } else if (operationNumber == 6) {
                // get
                if (!ads.isEmpty()) {
                    int idx = StdRandom.uniform(0, ads.size());
                    message += "get(" + idx + ")\n";
                    assertEquals(message, ads.get(idx), sad.get(idx));
                }
            }
        }
    }
}
