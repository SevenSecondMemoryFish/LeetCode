import java.lang.reflect.Array;
import java.util.HashMap;

public class RomanToInt13 {
    static HashMap<String,Integer> map = new HashMap<>(){{
        put("I",1);
        put("V",5);
        put("X",10);
        put("L",50);
        put("C",100);
        put("D",500);
        put("M",1000);
        put("IV",4);
        put("IX",9);
        put("XL",40);
        put("XC",90);
        put("CD",400);
        put("CM",900);
    }};
    public static void main(String[] args) {
        romanToInt("III");
    }

    public static int romanToInt(String s) {
        String[] sArray = s.split("");
        Integer count = sArray.length;
        Integer value = 0;
        for (int i = 0; i < count; i++) {
            String key = sArray[i];
            Integer value1 = map.get(key);
            if (i + 1 < count) {
                String nextKey = sArray[i + 1];
                Integer nextValue = map.get(nextKey);
                if (nextValue > value1) {
                    nextValue = map.get(key+nextKey);
                    if (nextValue > 0) {
                        value = value + nextValue;
                        i++;
                    }
                } else if (value1 >= nextValue) {
                    if (i + 2 < count && map.get(nextKey + sArray[i+2]) != null) {
                        value = value + value1;
                        continue;
                    }
                    i = i + 1;
                    value1 = value1 + nextValue;
                    boolean isNext = true;
                    while (isNext && i+1 < count && map.get(sArray[i+1]) <= nextValue) {
                        if (i + 2 < count && map.get(sArray[i+1] + sArray[i+2]) != null) {
                            isNext = false;
                        } else {
                            nextKey = sArray[i+1];
                            nextValue = map.get(nextKey);
                            value1 = value1 + nextValue;
                            i = i + 1;
                        }
                    }
                    value = value + value1;
                }
            } else {
                value = value + value1;
            }
        }
        return value;
    }
}
/**
 * 1.leetcode 13题目 url：https://leetcode-cn.com/problems/roman-to-integer/
 */
