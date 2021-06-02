package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1441_用栈操作构建数组 {
    public List<String> buildArray(int[] target, int n) {
        int max = target[target.length - 1];
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int index = Arrays.binarySearch(target,i);
            if (index >= 0) {
                arrayList.add("Push");
            } else {
                arrayList.add("Push");
                arrayList.add("Pop");
            }
            if (max == i)break;
        }
        return arrayList;
    }
}
