package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * lettcode: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class _142_环形链表2 {
    /**
     * 解题思路：使用快慢指针，找出第一次相遇点，再让快指针只想head，且此时快指针是一步一步走，当再次相遇即是入口处
     *  1.定义从首节点到环线开始节点的步骤为a,环线节点是b
     *  2.当第一次相遇的时候慢指针走了s步，快指针走了f步,相遇时候，f = 2s
     *      2.1此时快指针也是 f = s + n*b,快指针可能饶了n券了
     *      2.2，计算得知s = nb，f = 2*nb
     *  3.关键时刻到了，每次走到环线入口节点步数为  k = a + nb
     *      3.1 如果让slow走到环形的入口节点还需要走a步，那么是不是就是从head走到环线入口点就是a步呢，所以将head赋值给快指针，
     *      如果 slow和fast刚好相等是不是就是环形入口处
     */
    public ListNode nb_detectCycle(ListNode head) {
        if (head == null || head.next == null)return null;
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null)return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    /**
     * 垃圾写法。判断是否包含指针即可
     */
     public ListNode detectCycle(ListNode head) {
         if (head == null || head.next == null)return null;
         ListNode slow = head;
         List<ListNode> list = new ArrayList<>();
         list.add(slow);
         while (slow != null && slow.next != null) {
             slow = slow.next;
             int a = list.indexOf(slow);
             if (list.indexOf(slow) != -1){
                 return slow;
             }
             list.add(slow);
         }
        return null;
    }
}
