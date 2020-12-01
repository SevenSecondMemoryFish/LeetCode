package 链表;

import java.util.ArrayList;
import java.util.List;

public class _82_删除排序链表中的重复元素II {
    public static void main(String[] args) {
        int[] index = {2,3,4,5};
         List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    /**
     * 解题思路：
     *  1.创建一个空节点header
     *  2.创建一个空节点的last节点，以及创建一个head便利的前置节点before
     *  3.当遍历节点，满足不和before相等以及不和next相等，那么当前结节就可以保存在last节点的next，并更新last节点
     *
     *  当一个节点和之前节点以及之后节点不想等，此节点就是需要结果的节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)return head;
        ListNode header = new ListNode(0);
        ListNode a = head;
        ListNode last = header;
        ListNode before = null;
        while (a.next != null) {
            if (before == null){
                if (a.val != a.next.val) {
                    last.next = a;
                    last = last.next;
                } else {
                    last.next = null;
                }
            } else {
                if (before.val != a.val && a.val != a.next.val) {
                    last.next = a;
                    last = last.next;
                } else {
                    last.next = null;
                }
            }
            before = a;
            a = a.next;
        }
        if (a.val != before.val) {
            last.next = a;
        }
        return header.next;
    }
}
