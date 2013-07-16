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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        ArrayList<Integer> ret =  new ArrayList<Integer>();
        if(root == null)    return ret;
        while(!s.isEmpty()){
            TreeNode top = s.peek();
            if(top.left != null){
                s.push(top.left);
                top.left = null;
                continue;
            }else{
                ret.add(top.val);
                s.pop();
                if(top.right != null){
                    s.push(top.right);
                    top.right = null;
                }
            }
        }
        return ret;
    }
}
