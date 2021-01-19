package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode: https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
public class _725_分隔链表 {

    public static void main(String[] args) {
        int[] lists = {1,2,3,4};
        ListNode[] hh = splitListToParts(ListNode.createList(lists),5);
        System.out.println(hh);
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        List<ListNode> lists = new ArrayList<>();
        ListNode current = root;
        int index = 0;
        while (current != null) {
            index++;
            current = current.next;
        }
        int residue = index % k;
        int trade = index / k;
        int hh = 0;
        current = root;
        while (hh < k) {
           hh++;
           if (trade == 0) {
                if (residue > 0) {
                    residue--;
                    ListNode node = root;
                    node = root;
                    root = root.next;
                    node.next = null;
                    lists.add(node);
                } else {
                    lists.add(null);
                }
            } else {
               index = 0;
               ListNode node = current;
               while (index < trade) {
                   index++;
                   root = root == null ? null : root.next;
               }
               if (residue > 0) {
                    residue--;
                    node = root;
                    root = root == null ? null : root.next;
                }
               node.next = null;
               lists.add(current);
               current = root;
           }
        }
        return lists.toArray(new ListNode[lists.size()]);
    }
}
