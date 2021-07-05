package Stack;

import 链表.ListNode;

import java.util.Stack;

public class _143_重排链表 {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        reorderList(ListNode.createList(ints));
    }
    public static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            ListNode h = head;
            stack.push(h);
            head = head.next;
        }
        ListNode h = new ListNode(-1);
        head = h;
        int length = stack.size() / 2;
        for (int i = 0; i < length; i++) {
            ListNode header = stack.get(i);
            head.next = header;
            header.next = stack.get(stack.size() - i - 1);
            head = header.next;
        }
        if (stack.size() % 2 != 0) {
            head.next = stack.get(length);
            head = head.next;
        }
        head.next = null;
        head = h.next;
        //while (h != null) {
        //    System.out.println(h.val);
        //    h = h.next;
        //}
    }
}
