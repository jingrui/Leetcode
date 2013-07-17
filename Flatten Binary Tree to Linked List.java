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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)    return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        TreeNode cur;
        TreeNode prev = new TreeNode(0);
        while(!s.isEmpty()){
            cur = s.pop();
            prev.right = cur;
            if(cur.right!=null)
                s.push(cur.right);
            if(cur.left !=null){
                s.push(cur.left);
                cur.left = null;
            }
            prev = cur;
        }
    }
}
