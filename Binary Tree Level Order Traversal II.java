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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null)    return ret;
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        LinkedList<TreeNode> ll2 = new LinkedList<TreeNode>();
        ll.add(root);
        while(!ll.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            while(!ll.isEmpty()){
                TreeNode top = ll.pop();
                if(top.left!=null)   ll2.add(top.left);
                if(top.right!=null)  ll2.add(top.right);
                tmp.add(top.val);
            }
            ret.add(0,tmp);
            ll = new LinkedList<TreeNode>(ll2);
            ll2 = new LinkedList<TreeNode>();
        }
        return ret;
    }
}
