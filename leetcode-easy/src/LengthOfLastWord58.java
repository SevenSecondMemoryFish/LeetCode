public class LengthOfLastWord58 {
    public static void main(String[] args) {
        int length = lengthOfLastWord("Hello World");
        System.out.println(length);
    }

    public static int lengthOfLastWord(String s) {
        String[] list = s.split(" ");
        if (list.length <= 0)return 0;
        return list[list.length-1].length();
    }
}
/**
 * leetcode 题目：58，地址：https://leetcode-cn.com/problems/length-of-last-word/
 * 解题思路：
 *  根据空格起个字符串，取出最后一个字符串即可，但是要判断，如果字符串是空，要返回0
 */
