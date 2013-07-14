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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        LinkedList<TreeNode> ll2 = new LinkedList<TreeNode>();
        ll.add(root);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        while(!ll.isEmpty()){
            ArrayList<Integer> oneLevel = new ArrayList<Integer>();
            while(!ll.isEmpty()){
                TreeNode cur = ll.poll();
                if (cur!=null){
                    oneLevel.add(cur.val);
                    ll2.add(cur.left);
                    ll2.add(cur.right);
                }
            }
            if(!oneLevel.isEmpty())
                ret.add(oneLevel);
            ll = new LinkedList<TreeNode>(ll2);
            ll2 = new LinkedList<TreeNode>();
        }
        return ret;
    }
}
