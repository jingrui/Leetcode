// fast enough for large input
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<Integer> sums = new ArrayList<Integer>();
    
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(sums.size()==j)
                    sums.add(triangle.get(i).get(j));
                else{
                    sums.set(j,triangle.get(i).get(j)+Math.min(sums.get(j),sums.get(j+1)));
                }
            }
        }
        return sums.get(0);
    }
}
// not fast enough
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
