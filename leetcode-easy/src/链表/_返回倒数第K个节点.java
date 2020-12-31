package 链表;

public class _返回倒数第K个节点 {

    /**
     * 使用快慢指针来解决。先用快指针走k步，再同时走快指针余下的步数，此时满指针针对的node，就是倒数k的node
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode prev = head, start = prev;
        while (k > 0) {
            start = start.next;
            k--;
        }
        while (start != null) {
            start = start.next;
            prev = prev.next;
        }
        return prev.val;
    }
}
