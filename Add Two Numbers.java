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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1==null)    return l2;
        if(l2==null)    return l1;
        ListNode ret = new ListNode((l1.val+l2.val)%10);
        ListNode realret = ret;
        int carry = (l1.val+l2.val)/10;
        l1 = l1.next;
        l2 = l2.next;

        while((carry != 0)||(l2!=null)||(l1!=null)){
            ret.next = new ListNode(((l1!=null?l1.val:0)+(l2!=null?l2.val:0)+carry)%10);
            carry = ((l1!=null?l1.val:0)+(l2!=null?l2.val:0)+carry)/10;
            l1 = (l1 == null)?null:l1.next;
            l2 = (l2 == null)?null:l2.next;
            ret = ret.next;
        }
        return realret;
    }
}
