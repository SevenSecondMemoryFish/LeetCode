package Stack;

import java.util.Stack;

class CQueue {
    private Stack<Integer> popStack = new Stack<>();
    private Stack<Integer> pushStack = new Stack<>();
    public CQueue() {}

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            return  -1;
        }
        if (popStack.isEmpty() && !pushStack.isEmpty()) {
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
}