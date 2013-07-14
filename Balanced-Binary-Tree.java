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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return helper(root,new int[]{0});
    }
    public boolean helper(TreeNode root, int[] max){
        if(root == null){
            max[0] = 0;
            return true;
        }
        //System.out.println("root.val = "+root.val);
        int[] lmax = new int[]{0};
        int[] rmax = new int[]{0};
        boolean lret = helper(root.left,lmax);
        boolean rret = helper(root.right,rmax);
        //System.out.println("after return from child,lmax = "+lmax[0]+",rmax = "+rmax[0]);

        if((lret == false)||(rret == false)||(Math.abs(lmax[0]-rmax[0]) > 1))
            return false;
        
        max[0] = Math.max(lmax[0],rmax[0])+1;
        return true;
    }
}
