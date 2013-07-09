/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
        if (root==null) return;
        if (root.left==null && root.right==null) return;
        TreeLinkNode rsbling = root.next;
        root.left.next = root.right;
        if (rsbling!=null) {
            root.right.next = rsbling.left;
        }
        connect(root.left);
        connect(root.right);
    }
}

// not that smart one
public static void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        LinkedList<TreeLinkNode> ll = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> ll2 = new LinkedList<TreeLinkNode>();
        if(root != null)
            ll.add(root);
        while(!ll.isEmpty()){
            while(!ll.isEmpty()){
                TreeLinkNode cur = ll.poll();
                if (cur.left!=null)
                    ll2.add(cur.left);
                if (cur.right!=null)
                    ll2.add(cur.right);
                
                cur.next = ll.peek();
            }
            ll = new LinkedList(ll2);
            ll2 = new LinkedList();
        }
    }
