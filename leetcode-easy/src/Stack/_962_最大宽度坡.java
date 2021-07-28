package Stack;

import java.util.Stack;

public class _962_最大宽度坡 {
    public static void main(String[] args) {
        int[] ints = new int[] {9,8,1,0,1,9,4,0,4,1};
        maxWidthRamp(ints);
    }

    /**
     * 超出时间限制了，哎
     */
    public static int maxWidthRamp(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j] && i - j > result) {
                    result = i - j;
                    break;
                }
            }
        }
        return result;
    }
}
