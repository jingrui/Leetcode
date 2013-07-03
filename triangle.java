public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(triangle,0,0);
    }
    public int helper(ArrayList<ArrayList<Integer>> triangle, int level, int index){
        if(level == (triangle.size()-1))
            return triangle.get(level).get(index);
            
        return triangle.get(level).get(index)
            + Math.min(helper(triangle,level+1,index),helper(triangle,level+1,index+1));
    }
}
