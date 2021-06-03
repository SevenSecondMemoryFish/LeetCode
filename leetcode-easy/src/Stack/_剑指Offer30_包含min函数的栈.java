package Stack;
import java.util.Stack;

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    int kMin = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {}

    public void push(int x) {
        stack.push(kMin);
        if (x<kMin)kMin = x;
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        kMin = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return kMin;
    }
}