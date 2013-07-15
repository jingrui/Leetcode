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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode cur = new ListNode(-1);
        ListNode head = cur;

        while(!lists.isEmpty()){
           
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = 0; i < lists.size(); i++){
                if(lists.get(i) == null){
                    lists.remove(i--);
                    continue;
                }
                if(lists.get(i).val < min){
                    index = i;
                    min = lists.get(i).val;
                }
            }
            if(min == Integer.MAX_VALUE)    return head.next;
            cur.next = new ListNode(min);
            cur = cur.next;
            lists.set(index,lists.get(index).next);
        }
        return head.next;
    }
}
