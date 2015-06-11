package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 */
public class StackUsingQueues extends TestCase {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    /**
     * Push to queue 2 and then put all elements in queue 1 on top of queue 2. then swap queue 1 and queue 2. so,
     * push(1) would put 1 in queue2, then it is swapped so queue 1 would have 1 and queue2 would be empty
     * push(2) would put 2 in queue2, and 1 on top of 2. so top() would return 2 like a stack and so on.
     * @param x
     */

    // Push element x onto stack.
    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue1.remove();
    }

    // Get the top element.
    public int top() {
        return queue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    /**
     * Tests.
     */
    public void testOne() {
        push(1);
        assertTrue(top() == 1);
    }
}
