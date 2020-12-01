package 链表;

import java.util.List;

public class ListNode {

    static ListNode createList(int[] list) {
        ListNode header = new ListNode(list[0]);
        ListNode before = header;
        for (int index = 1; index < list.length; index++) {
            before.next = new ListNode(list[index]);
            before = before.next;
        }
        return  header;
    }

    static ListNode createList(List<Integer> list) {
        ListNode header = new ListNode(list.get(0));
        ListNode before = header;
        for (int index = 1; index < list.size(); index++) {
            before.next = new ListNode(list.get(index));
            before = before.next;
        }
        return  header;
    }
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
