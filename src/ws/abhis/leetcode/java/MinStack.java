package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack extends TestCase {

    private List<Integer> allElements = new ArrayList<>(); //List containing all elements in insertion order
    private List<Integer> minElements = new ArrayList<>(); //Min element at each insertion step
    private int listCount = -1; //Current count

    /**
     * Store min for each level in min list
     * To find min for each level, compare with min from prev level
     * @param x
     */
    public void push(int x) {
        allElements.add(x);
        if (minElements.size() > 0) {
            minElements.add(Math.min(x, minElements.get(listCount)));
        } else {
            minElements.add(x);
        }
        listCount = listCount + 1;
    }

    public void pop() {
        allElements.remove(listCount);
        minElements.remove(listCount);
        listCount = listCount - 1;
    }

    public int top() {
        return allElements.get(listCount);
    }

    public int getMin() {
        return minElements.get(listCount);
    }

    /**
     * Test cases
     */
    public void testOne() {
        push(-3);
        assertTrue(getMin() == -3);
    }
    public void testTwo() {
        push(-2); push(0); push(-1);
        int x = getMin(), y = top();
        pop();
        int z = getMin();
        assertTrue(x == -2 && y == -1 && z == -2);
    }
}
