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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode ret = head;
        ListNode tmp = head;
        while(n-- > 0)
            tmp = tmp.next;
            
        if(tmp == null) return ret.next;
        while(tmp.next != null){
            tmp = tmp.next;
            head = head.next;
        }
        head.next = head.next.next;
        return ret;
    }
}
