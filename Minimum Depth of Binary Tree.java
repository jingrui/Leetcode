/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        LinkedList<TreeNode> ll2 = new LinkedList<TreeNode>();
        if(root == null) return 0;
        ll.add(root);
        int level = 0;
        while(true){
            level++;
            while(!ll.isEmpty()){
                TreeNode cur = ll.poll();
                if((cur.left == null)&&(cur.right == null))
                    return level;
                else{
                    if(cur.right!=null)
                        ll2.add(cur.right);
                    if(cur.left!=null)
                        ll2.add(cur.left);
                }
            }
            ll = new LinkedList<TreeNode>(ll2);
            ll2 = new LinkedList<TreeNode>();
        }
    }
}
