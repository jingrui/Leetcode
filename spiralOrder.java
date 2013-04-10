// The more elegant the code is, the easier it is to code
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        int beginY = 0, endY = matrix.length - 1;
        if(endY < 0) return result;
        int beginX = 0, endX = matrix[0].length - 1;
        while (true) {
            // From left to right
            for (int i = beginX; i <= endX; ++i)
                result.add(matrix[beginY][i]);
            if (++beginY > endY) break;
            // From top down
            for (int i = beginY; i <= endY; ++i)
                result.add(matrix[i][endX]);
            if (beginX > --endX) break;
            // From right to left
            for (int i = endX; i >= beginX; --i)
                result.add(matrix[endY][i]);
            if (beginY > --endY) break;
            // From bottom up
            for (int i = endY; i >= beginY; --i)
                result.add(matrix[i][beginX]);
            if (++beginX > endX) break;
        }
        return result;
    }
}
