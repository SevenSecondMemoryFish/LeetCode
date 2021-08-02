package Stack;

import java.util.Stack;

class CustomStack {

    private  int maxLength = 0;
    private Stack<Integer> stack = new Stack<>();
    public CustomStack(int maxSize) {
        maxLength = maxSize;
    }

    public void push(int x) {
        if (stack.size() >= maxLength)return;
        stack.push(x);
    }

    public int pop() {
        return stack.isEmpty() ? -1 :  stack.pop();
    }

    public void increment(int k, int val) {
        int size = k > stack.size() ? stack.size() : k;
        for (int i = 0; i < size; i++) {
            stack.set(i,stack.get(i) + val);
        }
    }
}
