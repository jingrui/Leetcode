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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder.length == 0)    return null;
        TreeNode root = new TreeNode(preorder[0]);
        // find the index in inorder
        int rootindex = 0;
        for(int i = 0; i< inorder.length; i++)
            if(inorder[i] == preorder[0]){
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
            lp[i] = preorder[i+1];
        for(int i = 0; i < rp.length; i++)
            rp[i] = preorder[preorder.length - rp.length + i];            
        root.left  = buildTree(lp,li);
        root.right = buildTree(rp,ri);
        return root;
    }
}
