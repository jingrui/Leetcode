// DP. O(n^2)
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][]ret = new int[m+1][n+1];
        for(int i = 0; i <= m; i++)
            ret[i][n] = 0;
        for(int i = 0; i <= n; i++)
            ret[m][i] = 0;
        ret[m][n-1] = 1;
        for(int i = n-1;i >= 0; i--)
            for(int j = m-1; j >= 0; j--)
                ret[j][i] = ret[j+1][i]+ret[j][i+1];
        return ret[0][0];
    }
}
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
