public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int r = matrix.length-1;
        int c = matrix[0].length-1;
        int i = 0, j = c;
        while(( i <= r)&&(j >=0)){
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
