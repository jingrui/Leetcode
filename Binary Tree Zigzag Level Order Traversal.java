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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        LinkedList<TreeNode> ll2 = new LinkedList<TreeNode>();
        ll.add(root);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int counter = -1;
        while(!ll.isEmpty()){
            counter++;
            ArrayList<Integer> oneLevel = new ArrayList<Integer>();
            while(!ll.isEmpty()){
                TreeNode cur = ll.poll();
                if (cur!=null){
                    oneLevel.add(cur.val);
                    if(counter%2 == 0){
                        ll2.push(cur.left);
                        ll2.push(cur.right);
                    } else {
                        ll2.push(cur.right);
                        ll2.push(cur.left);
                    }
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
