package Stack;

import java.util.Stack;

public class _682_棒球比赛 {
    public static void main(String[] args) {
        String[] list = {"5","2"};
        calPoints(list);
    }
    public static int calPoints(String[] ops) {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String item = ops[i];
            if (item.equals("C")) {
                integerStack.pop();
            } else if (item.equals("D")) {
                Integer value = integerStack.peek()*2;
                integerStack.push(value);
            } else if (item.equals("+")) {
                if (integerStack.size() < 2)continue;
                Integer before = integerStack.get(integerStack.size() - 2);
                Integer value = integerStack.peek();
                integerStack.push(before + value);
            } else {
                Integer value = Integer.valueOf(item);
                integerStack.push(value);
            }
        }
        Integer sum = 0;
        for (Integer integer : integerStack) {
            sum += integer;
        }
        return sum;
    }

}
