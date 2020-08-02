public class CountAndSay38 {
    public static void main(String[] args) {

        String hh = countAndSay(4);
        String dd = leetcodeCountAndSay(4);
        System.out.println(hh);
    }

    public static String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }
        String beforeString = countAndSay(n-1);
        String[] beforeArray = beforeString.split("");
        int count = beforeArray.length;
        StringBuffer say = new StringBuffer();
        for (int index = 0; index < count; index++) {
            String value = beforeArray[index];
            var a = 1;
            while (index + 1 < count && value.equals(beforeArray[index+1])) {
                a += 1;
                index += 1;
            }
            say.append(a).append(value);
        }
        return say.toString();
    }

    /**
     * leetcode 大佬写法
     */

    public static String leetcodeCountAndSay(int n) {
        if (n <= 1) {
            return "1";
        }
        String beforeString = leetcodeCountAndSay(n -1);
        StringBuffer res = new StringBuffer();
        int length = beforeString.length();
        int a = 0;
        for (int index = 1; index < length + 1; index++) {
            if (index == length) {
                return res.append(index - a).append(beforeString.charAt(a)).toString();
            } else if (beforeString.charAt(a) != beforeString.charAt(index)) {
                res.append(index-a).append(beforeString.charAt(index));
                a = index;
            }
        }
        return res.toString();
    }
}
/**
 * leetcode 外观数列 38题，url：https://leetcode-cn.com/problems/count-and-say/
 * 1.使用递归的方式，获取上一个数字的描述，
 * 2.在遍历下上一个数字的描述，找到数字b后面不相等数字c，之间位置相差a，则是,a个b,依次拼接即可
 */




