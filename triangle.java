// O(n)
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = triangle.get(triangle.size()-1);
        for(int i = triangle.size()-2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                ret.set(j,triangle.get(i).get(j)+Math.min(ret.get(j),ret.get(j+1)));
                
        return ret.get(0);
    }
}
// O(2^n)
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
