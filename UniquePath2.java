public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (obstacleGrid[0].length == 0)
            return 0;
        int [][]ret = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        
        int m = ret.length-1;
        int n = ret[0].length-1;
        for(int i = 0; i <= m; i++)
            ret[i][n] = 0;
        for(int i = 0; i <= n; i++)
            ret[m][i] = 0;
        ret[m][n-1] = 1;
        for(int i = n-1;i >= 0; i--)
            for(int j = m-1; j >= 0; j--){
                if (obstacleGrid[j][i] == 0)
                    ret[j][i] = ret[j+1][i]+ret[j][i+1];
                else
                    ret[j][i] = 0;
            }
        return ret[0][0];
    }
}
