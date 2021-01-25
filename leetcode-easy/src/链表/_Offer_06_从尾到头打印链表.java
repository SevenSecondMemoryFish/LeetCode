package 链表;

import java.util.ArrayList;
import java.util.List;

public class _Offer_06_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if (head == null)return new int[0];
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] array = new int[list.size()];
        int index = 0;
        for (int i = list.size() -1; i >= 0; i--) {
            array[index] = list.get(i);
            index++;
        }
        return array;
    }
}
