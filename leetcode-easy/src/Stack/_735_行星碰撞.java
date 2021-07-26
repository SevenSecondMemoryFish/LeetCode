package Stack;

import java.util.Stack;

public class _735_行星碰撞 {
    public static void main(String[] args) {
        int[] ints = new int[] {-2,-2,1,-2};
        asteroidCollision(ints);
    }

    /**
     * 未弄明白，为何stack.peek() < 0的时候，不会发生碰撞 ，只有stack.peek() > 0 的时候才会发生碰撞
     * 1.有个点很好，就是当发生碰撞后，不需要将碰撞后的值添加到stack的时候，可以将值设置未最大，最小。依次判断出是否需要添加到stack里面
     * @param asteroids
     * @return
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            Integer index = asteroids[i];
            if (stack.isEmpty()) {
               stack.push(index);
            } else {
                Integer left = stack.peek();
                if (left > 0 && index < 0) {
                    while (!stack.isEmpty() && stack.peek() > 0 && index < 0) {
                        if (Math.abs(stack.peek()) > Math.abs(index)) {
                            index = Integer.MAX_VALUE;
                            break;
                        } else if (Math.abs(stack.peek()) == Math.abs(index)) {
                            stack.pop();
                            index = Integer.MAX_VALUE;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                    if (index != Integer.MAX_VALUE) {
                        stack.push(index);
                    }
                } else {
                    stack.push(index);
                }
            }
        }
        int[] ints = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
            ints[i] = stack.get(i);
        }
        return ints;
    }
}
