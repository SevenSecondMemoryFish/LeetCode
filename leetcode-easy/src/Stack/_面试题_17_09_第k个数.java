package Stack;

import java.util.ArrayList;

public class _面试题_17_09_第k个数 {

    public int nb_getKthMagicNumber(int k) {
        int[] ints = new int[k+1];
        ints[1] = 1;
        for (int idx1 = 1, idx2 = 1,idx3 = 1, i = 2; i <= k; i++) {
            int a = ints[idx1] * 3, b = ints[idx2] * 5, c = ints[idx3] * 7;
            int d = Math.min(a,Math.min(b,c));
            if (d == a) idx1++;
            if (d == b) idx2++;
            if (d == c) idx3++;
            ints[i] = d;
        }
        return ints[k];
    }

    public int getKthMagicNumber(int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            int index = i;
            while (index % 3 == 0) {
                index = index / 3;
            }
            while (index % 5 == 0) {
                index = index / 5;
            }
            while (index % 7 == 0) {
                index = index / 7;
            }
            if (index == 1) {
                arrayList.add(i);
            }
            if (k == arrayList.size()) break;
        }
        return arrayList.get(arrayList.size()-1);
    }
}
