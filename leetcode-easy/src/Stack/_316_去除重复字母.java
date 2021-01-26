package Stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _316_去除重复字母 {
    public static void main(String[] args) {
        removeDuplicateLetters("bcabc");
    }
    public static String removeDuplicateLetters(String s) {
        Set<String> set = new HashSet<>();
        String[] strList = s.split("");
        for (int i = 0; i < strList.length; i++) {
            String str = strList[i];
            if (set.contains(str)) continue;
            set.add(str);
        }
        s = "";
        List list = Arrays.asList(set.toArray());
        for (int i = 0; i < list.size(); i++) {
            s += list.get(i);
        }
        return s;
    }
}
