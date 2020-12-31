package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/partition-list-lcci/
 */
public class _02_04_分割链表 {
    public static void main(String[] args) {
       int[] list = {1,4,3,2,5,2};
       ListNode listNode = ListNode.createList(list);
       listNode = partition(listNode,3);
        System.out.println(listNode);
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode maxNode = new ListNode(0);
        ListNode minNode = new ListNode(0);
        ListNode max = maxNode;
        ListNode min = minNode;
        while (head != null) {
            if (head.val >= x) {
                max.next = head;
                max = max.next;
            } else {
                min.next = head;
                min = min.next;
            }
            head = head.next;
        }
        max.next = null;
        min.next = maxNode.next;
        return minNode.next;
    }
}
