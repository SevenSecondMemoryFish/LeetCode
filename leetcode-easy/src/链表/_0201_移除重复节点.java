package 链表;

import java.util.HashSet;
import java.util.Set;

public class _0201_移除重复节点 {
     public ListNode removeDuplicateNodes(ListNode head) {
         ListNode pre = new ListNode(0);
         pre.next = head;
         ListNode current = pre;
         Set hs = new HashSet();
         while (head != null) {
             if (hs.contains(head.val)) {
                 current.next = head.next;
             } else {
                 hs.add(head.val);
                 current = current.next;
             }
             head = head.next;
         }

         return pre.next;
     }
}
