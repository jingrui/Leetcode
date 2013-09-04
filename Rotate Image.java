public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = matrix.length;
        int l = length-1;
        int tmp;
        for(int i = 0; i <= length/2-1; i++)
            for(int j = 0; j <= length/2-1; j++)
            {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[l-j][i];
                matrix[l-j][i] = matrix[l-i][l-j];
                matrix[l-i][l-j] = matrix[j][l-i];
                matrix[j][l-i] = tmp;
            }
            
        if(length%2 == 1){
            for(int i = 0; i <= length/2; i++){
                tmp = matrix[i][length/2];
                matrix[i][length/2] = matrix[length/2][i];
                matrix[length/2][i] = matrix[l-i][length/2];
                matrix[l-i][length/2] = matrix[length/2][l-i];
                matrix[length/2][l-i] = tmp;
            }
        }
    }
}
