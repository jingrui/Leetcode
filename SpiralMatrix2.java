public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][0];
        
        int[][]ret = new int[n][n];
        int Xs = 0, Xe = n-1;
        int Ys = 0, Ye = n-1;
        int j = 1;
        while(true){
            for(int i = Ys; i <= Ye; i++)
                ret[Xs][i] = j++;
            
            if(++Xs > Xe) break;
            for(int i = Xs; i <= Xe; i++)
                ret[i][Ye] = j++;
            
            if(Ys > --Ye) break;
            for(int i = Ye; i >= Ys; i--)
                ret[Xe][i] = j++;
            
            if(Xs > --Xe) break;
            for(int i = Xe; i >= Xs; i--)
                ret[i][Ys] = j++;
            
            if(++Ys > Ye) break;
        }
        return ret;        
    }
}
