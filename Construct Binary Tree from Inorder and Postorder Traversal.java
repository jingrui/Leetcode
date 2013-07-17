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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length == 0)    return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        // find the index in inorder
        int rootindex = 0;
        for(int i = 0; i< inorder.length; i++)
            if(inorder[i] == postorder[postorder.length-1]){
                rootindex = i;
                break;
            }
            
        int[] li = new int[rootindex];
        int[] ri = new int[inorder.length - rootindex -1];
        for(int i = 0; i < li.length; i++)
            li[i] = inorder[i];
        for(int i = 0; i < ri.length; i++)
            ri[i] = inorder[inorder.length - ri.length +i];
            
        int[] lp = new int[li.length];
        int[] rp = new int[ri.length];
        for(int i = 0; i < lp.length; i++)
            lp[i] = postorder[i];
        for(int i = 0; i < rp.length; i++)
            rp[i] = postorder[postorder.length - rp.length + i -1];            
        root.left  = buildTree(li,lp);
        root.right = buildTree(ri,rp);
        return root;
    }
}
