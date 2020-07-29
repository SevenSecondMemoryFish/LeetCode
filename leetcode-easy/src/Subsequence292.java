public class Subsequence292 {

    public static void main(String[] args) {
        boolean isSub = isSubsequence("abc", "acbjs");
        System.out.println(isSub);
    }

    public static boolean isSubsequence(String s, String t) {
        char[] sCharArray = s.toCharArray();
        int index = -1;
        for (char r : sCharArray) {
            /** 从前一个字符再t里面的位置+1开始搜索下一个字符是否存在*/
            index = t.indexOf(r,index+1);
            if (index == -1) return  false;
        }
        return true;
    }
}

/**
 * 1.leetcode 292题目 地址: https://leetcode-cn.com/problems/is-subsequence/
 * 2.结题思路：
 *  2.1 先讲s转化为char数组，从t里面开始搜索char字符
 *  2.2 开始搜索的位置，为s的上一个char字符在t里面的位置 +1 开始搜索，如果没有搜索到就是false
 */
