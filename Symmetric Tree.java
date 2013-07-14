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
    public boolean isSymmetric(TreeNode root) {
       LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        LinkedList<TreeNode> ll2 = new LinkedList<TreeNode>();
        if((root == null)||((root.left==null)&&(root.right==null))) return true;
        ll.add(root.left);
        ll.add(root.right);
        while(!ll.isEmpty()){
            while(!ll.isEmpty()){
                TreeNode left = ll.pollFirst();
                TreeNode right = ll.pollLast();
//                System.out.println("left = "+((left == null)?null:left.val)
//                      +",right = "+((right == null)?null:right.val));
                if((left == null)&&(right == null))   continue;
                if((left == null)||(right == null))   return false;
                if(left.val != right.val)   return false;
                
                ll2.addFirst(left.left);
                ll2.addFirst(left.right);
                
                ll2.addLast(right.right);
                ll2.addLast(right.left);
            }
            ll = new LinkedList<TreeNode>(ll2);
            ll2 = new LinkedList<TreeNode>();
//            for(int i =0; i< ll.size();i++){
//            	if(ll.get(i)!=null)
//            		System.out.println("ll["+i+"]="+ll.get(i).val);
//            	else
//            		System.out.println("ll["+i+"]="+ll.get(i));
//            }
        }
        return true;
    }
}
