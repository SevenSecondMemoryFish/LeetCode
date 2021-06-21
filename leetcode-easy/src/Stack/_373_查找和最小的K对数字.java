package Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 有些题目的答案看不懂，返回的数组是对的，只是位置不对
 */
public class _373_查找和最小的K对数字 {
    public static void main(String[] args) {
        int[] ints = {1,1,11};
        int[] ints1 = {2,4,6};
        kSmallestPairs(ints,ints1, 3);
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        ArrayList<List<Integer>> lists = new ArrayList<>();
        Integer index = 1;
        for (int i = 0; i < nums1.length; i++) {
            Integer h = nums1[i];
            if (i < nums1.length - 1) {
                if (h == nums1[i + 1]){
                    index++;
                   continue;
                }
            } else {
                index = 1;
            }
            Integer z = index;
            for (int j = 0; j < nums2.length; j++) {
                while (index > 0 & lists.size() < k) {
                    List<Integer> list = new ArrayList<>();
                    list.add(h);
                    list.add(nums2[j]);
                    lists.add(list);
                    index--;
                }
                index = z;
            }
            if (lists.size() == k) break;
        }
        return lists;
    }
}
