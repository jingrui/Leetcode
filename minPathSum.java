// ret[i][j] = min(ret[i][j+1],ret[i+1][j])+grid[i][j]
public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        //if (m == 0) return 0;
        int n = grid[0].length;
        int[][]ret = new int[m+1][n+1];
        for(int i = 0; i <= m; i++)
            ret[i][n] = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++)
            ret[m][i] = Integer.MAX_VALUE;
        ret[m][n-1] = 0;
        for(int i = n-1;i >= 0; i--)
            for(int j = m-1; j >= 0; j--)
                ret[j][i] = Math.min(ret[j+1][i],ret[j][i+1])+grid[j][i];
        return ret[0][0];
    }
}
