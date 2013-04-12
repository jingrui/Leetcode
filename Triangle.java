// exponential solution
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        return  triangle.get(0).get(0)+ Math.min(findmin(0,1,triangle),findmin(1,1,triangle));
    }
    public int findmin(int col, int row,ArrayList<ArrayList<Integer>> t){
        if (row >= t.size())
            return 0;
        if(row == (t.size()-1))
            return t.get(row).get(col);
        return t.get(row).get(col)+Math.min(findmin(col,row+1,t),findmin(col+1,row+1,t));
    }
}
