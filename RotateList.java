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
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null)
            return head;
        ListNode h = head;
        int size = 1; 
        while(h.next != null){
            size++;
            h = h.next;
        }
        n = n%size;
        // if no need to rotate
        if(n == 0)
            return head;
        n = size - n;
        h = head;
        for(int i = 0; i < (n-1); i++)
            h = h.next;
        ListNode newHead = h.next;
        h.next = null;
        h = newHead;
        while(h.next!=null)
            h = h.next;
        h.next = head;
        
        return newHead;
    }
}
