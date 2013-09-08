public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        return helper(candidates,candidates.length -1,target,new ArrayList<Integer>());
    }
    public ArrayList<ArrayList<Integer>> helper(int[] c,int index,int target,ArrayList<Integer> cur){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if(target == 0){
    		ret.add(cur);
    		return ret;
    	}
        if(index >= 0){
            if(target >= c[index]){
                // with it
                ArrayList<Integer> copy = new ArrayList<Integer>(cur);
                copy.add(0,c[index]);
                ret.addAll(helper(c,index,target-c[index],copy));
            }
            // without it
            ret.addAll(helper(c,index-1,target,cur));
        }
		return ret;
    }
}
