/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
    ListNode root = new ListNode(-1);
    ListNode pivot = new ListNode(x);
    ListNode root_last = root, pivot_last = pivot;

    ListNode cur_node = head;
    while (cur_node != null) {
        ListNode next = cur_node.next;
        if (cur_node.val < x) {
            root_last.next = cur_node;
            root_last = cur_node;
        } else {
            pivot_last.next = cur_node;
            pivot_last = cur_node;
            pivot_last.next = null;
        }
        cur_node = next;
    }
    root_last.next = pivot.next;

    return root.next;
}
}
