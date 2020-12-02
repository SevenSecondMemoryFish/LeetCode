package 链表;

import java.util.ArrayList;
import java.util.List;

public class _160_相交链表 {

    /**
     * 使用拼接来查找第一个相同的元素
     * 比如：headA   1  3  5  6  7
     *      headB   1  6  7
     *  使用拼接方式，来组成两个元素相等的列表，找出第一个相等的即可
     *      1  3  5  6  7  1  6  7
     *      1  6  7  1  3  5  6  7
     * @return
     */
    public ListNode nb_getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return ha;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)return null;
        if (headA == headB)return headA;
        List<ListNode> listA = new ArrayList<>();
        List<ListNode> listB = new ArrayList<>();
        ListNode a = headA;
        ListNode b = headB;
        listA.add(a);
        listB.add(b);
        int index = 0;
        while (a != null || b != null) {
            a = a == null ? null : a.next;
            b = b == null ? null : b.next;
            if (a == b)return b;
            index = listA.indexOf(b);
            if (index != -1) {
                if (index > listB.size())return b;
                return listA.get(index);
            }
            index = listB.indexOf(a);
            if (index != -1) {
                if (index > listA.size())return a;
                return listB.get(index);
            }
            listA.add(a);
            listB.add(b);
        }
        return null;
    }
}
