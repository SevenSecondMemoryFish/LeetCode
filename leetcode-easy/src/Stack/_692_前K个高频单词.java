package Stack;

import java.lang.reflect.Array;
import java.util.*;

public class _692_前K个高频单词 {
    public static void main(String[] args) {
        String[] strings = new String[34];
        strings[0] = "2";
        strings[1] = "23";
        strings[2] = "2";
        topKFrequent(strings,3);
    }
    public static List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (hashMap.containsKey(str)) {
                hashMap.put(str,hashMap.get(str) + 1);
            } else {
                hashMap.put(str,1);
            }
        }
        ArrayList<String> strings = new ArrayList<>(hashMap.keySet());
        Collections.sort(strings,new Comparator<String>() {
            @Override
            public int compare(String t, String t1) {
                int count1 = hashMap.get(t1);
                int count2 = hashMap.get(t);
                if (count1 == count2) {
                    return t.compareTo(t1);
                } else {
                    return count1 - count2;
                }
            }
        });
        ArrayList<String> strings1 = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            strings1.add(strings.get(i));
        }
        return strings1;
    }
}
