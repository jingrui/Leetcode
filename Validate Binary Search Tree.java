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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    public boolean helper(TreeNode root, int up,int bot){
        if(root==null)  return true;
        if((root.val < up)&&(root.val > bot)){
            return helper(root.left,root.val,bot)&&helper(root.right,up,root.val);
        }
        return false;
    }
}
