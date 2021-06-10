package Stack;

import java.util.Stack;
import java.util.Stack;

class _901_股票价格跨度 {
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(85));
    }
}



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