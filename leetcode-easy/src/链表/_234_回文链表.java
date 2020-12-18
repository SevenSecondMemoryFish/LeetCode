package 链表;

import java.util.Stack;

public class _234_回文链表 {

    public static void main(String[] args) {
        int[] list = {1,2};
        ListNode listNode = ListNode.createList(list);
        isPalindrome(listNode);
    }

    /**
     * 使用栈先进后出的原则进行比较
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val)return false;
            head = head.next;
        }
        return false;
    }
}
