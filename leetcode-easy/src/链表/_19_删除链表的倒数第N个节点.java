package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcodeurl：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(9);
        ListNode l2 = new ListNode(4);
        l2.next = l3;
        ListNode l1 = new ListNode(2);
        l1.next = l2;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> arrayList = new ArrayList<ListNode>();
        ListNode a = head;
        while (a != null) {
            arrayList.add(a);
            a = a.next;
        }
        int size = arrayList.size();
        if (size == n)return head.next;
        if (n==0){
            arrayList.get(size-1).next = null;
        } else {
            ListNode next = arrayList.get(size - n);
            ListNode before = arrayList.get(size - n - 1);
            before.next = next.next;
        }
        return head;
    }

    /** 解题思路：
     *  先定义一个start 和end 链表元素
     *  先将start移动n步，此时star就是将要移出的元素
     *  此时start距离结尾的元素个数就是倒数第n个元素之前的个数
     *  依次移动star和end，直到star.next == nul，则end刚好在是倒数第n-1的元素
     * @param head
     * @param n
     * @return
     */
    public ListNode nb_removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = start;
        while (n != 0){
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

}
