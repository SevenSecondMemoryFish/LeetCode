package Stack;
import java.util.Stack;

class StockSpanner {
    Stack<Integer> stack = new Stack<>();
    public StockSpanner() {

    }

    public int next(int price) {
        int index = 1;
        boolean isLoop = true;
        while (isLoop && stack.size() - index > 0) {
            isLoop = price >= stack.get(stack.size() - index);
            if (isLoop) {
                index++;
            }
        }
        stack.push(price);
        return index;
    }
}