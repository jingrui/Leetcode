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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)    return head;
        ListNode cur = head;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        while(cur != null){
            if (hm.containsKey(cur.val))
                hm.put(cur.val,hm.get(cur.val)+1);
            else
                hm.put(cur.val,1);
            cur = cur.next;
        }
        ListNode a = new ListNode(-1);
        a.next = head;
        cur = a;
        while(cur.next != null){
            if(hm.get(cur.next.val)>1){
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return a.next;
    }
}
