package Stack;

/**
 * 没有做对
 */
public class _1574_删除最短的子数组使剩余数组有序 {
    public int findLengthOfShortestSubarray(int[] arr) {
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) right = i;
            max = Math.max(max, arr[i]);
        }

        for (int i = arr.length - 1; i >=0 ; i--) {
            if (min < arr[i]) left = i;
            min = Math.min(min, arr[i]);
        }
        return left == right ? 0 : right - left + 1;
    }
}
