package Stack;

import java.util.Stack;

public class _739_每日温度 {
    /**
     * 1.定义一个保存下标的栈stack
     * 2.while栈，当temperatures[i] 的值大于 temperatures[stack.peek()] ，则弹出当前栈顶的元素，并且将它计算的天数复制给ints，注意ints 不赋值的时候表示的就是0
     * 3.再将当前的下标保存到stack中
     * 关键点：在于想到stack存储的是下标，以及temperatures[i] > temperatures[stack.peek()]的比较
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ints = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                ints[stack.peek()] = i  - stack.pop();
            }
            stack.push(i);
        }
        return ints;
    }
}
