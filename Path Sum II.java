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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root,sum,new ArrayList<Integer>());
    }
    public ArrayList<ArrayList<Integer>> helper(TreeNode root, int sum,ArrayList<Integer> ret) {
        ArrayList<ArrayList<Integer>> realret = new ArrayList<ArrayList<Integer>>();
        if(root == null)    return realret;
        ret.add(root.val);
        ArrayList<Integer> copy = new ArrayList<Integer>(ret);
        if(root.val == sum)
            if((root.left == null)&&(root.right == null)){
                realret.add(ret);
                return realret;
            }
        
        realret.addAll(helper(root.left,sum - root.val,ret));
        realret.addAll(helper(root.right,sum - root.val,copy));
        return realret;
    }
}
