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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        if(head.next == null)  return head;
        ListNode ret = head.next;
        head.next = swapPairs(ret.next);
        ret.next = head;
        return ret;
    }
}
