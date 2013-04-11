// DP. O(n^2)

// backtracking. Running time = O(2^n)
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(m,n,1,1);
    }
    public int helper(int m, int n, int row, int col){
        if((row == m)&&(col == n))
            return 1;
        int ret1 = 0,ret2 = 0 ;
        if (row < m)
            ret1 = helper(m,n,row+1,col);
        if (col < n)
            ret2 = helper(m,n,row,col+1);
        return ret1+ret2;    
    }
}
