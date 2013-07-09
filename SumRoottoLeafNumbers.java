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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root ==null) return 0;
        return helper(root,root.val);
    }
    int helper(TreeNode cur, int val){
        if ((cur.right == null)&&(cur.left == null))
            return val;
        int rret = 0, lret = 0;
        if(cur.right!=null)
            rret = helper(cur.right,val*10+cur.right.val);
        if(cur.left!=null)
            lret = helper(cur.left,val*10+cur.left.val);
        return rret+lret;
    }
    
}
