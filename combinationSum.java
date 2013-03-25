public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        ArrayList<Integer> al = new ArrayList<Integer>();
        helper(candidates,target,al,ret,0);
        return ret;
    }
    public void helper(int[] can, int t, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> ret, int i ){
      if (t == 0){
		ret.add(al);
		return;
	}
	if ((t < 0) || (i >= can.length))
		return;
		
        if (t >= can[i]){
        	for(int j = t/can[i]; j >= 0; j--){
        		ArrayList<Integer> newal = new ArrayList<Integer>(al);
        		for (int k = j; k > 0 ; k--)
        			newal.add(can[i]);
        		helper(can,t-j*can[i],newal,ret,i+1);
        	}
        	return;
        }
    }
}
