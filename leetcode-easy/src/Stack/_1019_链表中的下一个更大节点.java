package Stack;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 未解答出来
 */
public class _1019_链表中的下一个更大节点 {
    public static void main(String[] args) {


    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        while (head != null) {
            integers.add(head.val);
            for (int i = 0; i < integers.size(); i++) {
                int index = integers.get(i);
                if (index < head.val) {
                    int a = arrayList.size() > i ? arrayList.get(i) : 0;
                    if (a < head.val)arrayList.set(i,head.val);
                } else if (index == head.val) {
                    if (arrayList.size() > i) {
                        arrayList.set(i,0);
                    } else  {
                        arrayList.add(0);
                    }
                }
            }
            head = head.next;
        }
        int[] arras = new int[arrayList.size()];
        for (int i = 0; i < arras.length; i++) {
            System.out.println(arrayList.get(i));
            arras[i] = arrayList.get(i);
        }
        return arras;
    }
}
