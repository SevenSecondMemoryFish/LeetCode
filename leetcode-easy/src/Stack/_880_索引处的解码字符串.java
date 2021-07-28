package Stack;

public class _880_索引处的解码字符串 {

    public static void main(String[] args) {
       String a = nb_decodeAtIndex("le3a2", 9);
        System.out.println(Math.pow(2,63));
        System.out.println(a);
    }

    public static String decodeAtIndex(String s, int k) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int index = s.charAt(i) - '0';
                String str = buffer.toString();
                if (buffer.length() * (index + 1) > k) {
                    int h = k % str.length();
                    return String.valueOf(str.charAt(h-1));
                } else {
                    for (int j = 1; j < index; j++) {
                        buffer.append(str);
                    }
                }
            } else {
                buffer.append(s.charAt(i));
            }
        }
        return String.valueOf(buffer.charAt(k-1));
    }

    /**
     * 1.先遍历字符串取出s的解码字符串的大小
     * 2.倒序遍历字符串s，判断k %
     * @param s
     * @param k
     * @return
     */
    public static String nb_decodeAtIndex(String s, int k) {
        long length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                length *= s.charAt(i) - '0';
            } else {
                length++;
            }
        }
        for (int i = s.length() - 1; i >= 0 ; i--) {
            k = (int) (k % length);
            if (k == 0 && !Character.isDigit(s.charAt(i))) {
                return String.valueOf(s.charAt(i));
            }
            if (Character.isDigit(s.charAt(i))) {
                length /= s.charAt(i) - '0';
            } else {
                length--;
            }
        }
        return "";
    }

}
