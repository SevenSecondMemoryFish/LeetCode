package Stack;

import java.util.Stack;

public class _232_用栈实现队列 {

    private Stack<Integer> popStack = new Stack<>();
    private Stack<Integer> pushStack = new Stack<>();

    public _232_用栈实现队列() {

    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}
