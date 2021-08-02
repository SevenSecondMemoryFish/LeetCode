package Stack;

import java.util.Collection;
import java.util.Stack;

public class _1472_设计浏览器历史记录 {

    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();

    public _1472_设计浏览器历史记录(String homepage) {
        backStack.push(homepage);
    }

    public void visit(String url) {
        backStack.push(url);
        forwardStack.clear();
    }

    public String back(int steps) {
        if (backStack.size() == 1) return backStack.peek();
        while (forwardStack.size() > 1 && steps > 0) {
             forwardStack.push(backStack.pop());
             steps--;
        }
        return backStack.peek();
    }

    public String forward(int steps) {
        if (forwardStack.isEmpty()) return backStack.peek();
        while (!forwardStack.isEmpty() && steps > 0) {
             backStack.push(forwardStack.pop());
             steps--;
        }
        return forwardStack.peek();
    }
}
