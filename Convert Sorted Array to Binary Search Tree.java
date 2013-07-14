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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0)   return null;
        int mid = (num.length-1)/2;
        int[] left = new int[mid];
        int[] right = new int[num.length-mid-1];
        
        for(int i = 0; i < left.length; i++)
            left[i] = num[i];
        for(int i = 0; i < right.length; i++)
            right[i] = num[i+mid+1];
        TreeNode cur = new TreeNode(num[mid]);
        cur.left = sortedArrayToBST(left);
        cur.right = sortedArrayToBST(right);
        return cur;
    }
}
