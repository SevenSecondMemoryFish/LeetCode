import java.util.stream.IntStream;

public class AddBinary67 {

    public static void main(String[] args) {
//        System.out.println("1".charAt(0)-'0');
        String binary = addBinary("11", "1");
        System.out.println(binary);
    }

    public static String addBinary(String a, String b) {
        String[] aArray = new StringBuffer(a).reverse().toString().split("");
        String[] bArray = new StringBuffer(b).reverse().toString().split("");
        int maxCount = Math.max(aArray.length, bArray.length);
        int hh = 0;
        StringBuffer resultBuffer = new StringBuffer();
        for (int index = 0; index < maxCount; index++) {
            Integer c = index < aArray.length ? Integer.parseInt(aArray[index]) : 0;
            Integer d = index < bArray.length ? Integer.parseInt(bArray[index]) : 0;
            Integer e = (c + d + hh) % 2;
            hh = (c + d + hh) / 2;
            resultBuffer.insert(0, e);
        }
        if (hh > 0) {
            resultBuffer.insert(0, hh);
        }
        return resultBuffer.toString();
    }

    /**
     * leetcode 上面别人牛逼写法
     * @param a
     * @param b
     * @return
     */
    public static String nb_addBinary(String a, String b) {
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int flag = 0;
        StringBuffer resultBuffer = new StringBuffer();
        while (aLength >= 0 || bLength >= 0) {
            int tmpA = aLength >= 0 ? a.charAt(aLength) - '0' : 0;
            int tmpB = bLength >= 0 ? b.charAt(bLength) - '0' : 0;
            Integer e = (tmpA + tmpB + flag) % 2;
            flag = (tmpA + tmpB + flag) / 2;
            resultBuffer.insert(0, e);
            aLength--;
            bLength--;
        }
        if (flag > 0) {
            resultBuffer.insert(0, flag);
        }
        return resultBuffer.toString();
    }
}
/**
 * leetcode: 二进制求和，url：https://leetcode-cn.com/problems/add-binary/
 * 解题思路：
 *  1.获取到字符串a的长度aLength，以及获取到字符串b的长度bLength
 *  2.开始while循环开始从最后面取出字符，并和'0'求减
 *  3.将a对应的数值tmpA，以及b对应的数值tmpB，已经进位的值flag，想加，取出余数e,以及进位数flag，余数e就是此位置的字符，拼接到字符串即可，最后tmpA、tmpB都--
 *  4.循环完毕后，看看进位数flag，是否有值，有值也拼接上去即可
 */
