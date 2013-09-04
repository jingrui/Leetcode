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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode cur = h;
        for(int i = 0; i <= (m-2); i++)
            cur = cur.next;
         // cur is the first ll last node
         // rlh is the 2nd ll first node
         // rlt is the 2nd ll last node
         // leftlist is the 3rd ll first node
        ListNode rlh = cur.next, rlt = cur.next;
        cur.next = null;
        for(int i = 0; i <= (n-m-1); i++)
            rlt = rlt.next;
        ListNode leftlist = rlt.next;
        rlt.next = null;
        cur.next = reverse(rlh);
        while(cur.next != null) cur = cur.next;
        cur.next = leftlist;
        
        return h.next;
    }
    public ListNode reverse(ListNode h){
        if ((h ==null)||(h.next == null)) return h;
        
        ListNode prev = h;
        ListNode cur  = prev.next;
        ListNode next = cur.next;
        prev.next = null;
        
        while( next != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        
        return cur;
    }
}

