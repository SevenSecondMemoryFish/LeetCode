package Stack;

public class _581_最短无序连续子数组 {
    public static void main(String[] args) {
        int[] ints = {2,6,4,8,10,9,15};
        findUnsortedSubarray(ints);
    }

    /**
     * 1.因为顺序是排好的，只需要找到左侧排好的下标left ，以及找到右侧排好的下标right即可，
     *  1.1 左侧排好的下标：
     *      我们从后面开始倒序遍历，当前值大于右侧便利出来的最小值，则这个值的下标则为左侧排好序的开启下标left
     *  1.2 右侧排好序的下标right：
     *      我们从前面排序，当前值小于左侧出来的最大值，则这个值的下标则为右侧排序好的开启下标right
     * 2.结果就是right - left + 1
     */
    public static int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) right = i;
            max = Math.max(max,nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (min < nums[i])left = i;
            min = Math.min(min,nums[i]);
        }

        return right == left ? 0 : right - left + 1;
    }
}
