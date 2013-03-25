public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        helper(num, target, ret,al, 0);
        for(int i = 0; i < ret.size(); i++){
            for(int j = i+1; j < ret.size(); j++){
                if (ret.get(i).equals(ret.get(j))){
                    ret.remove(j);
                    j--;
                }
            }
        }
        return ret;
    }
    public void helper(int[] n, int t, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> al,int i){
        if (t == 0){
            ret.add(al);
            return;
        } else if (( t < 0) || (i >= n.length)){
            return;
        } else {
            ArrayList<Integer> newal = new ArrayList<Integer>(al);
            newal.add(n[i]);
            helper(n,t-n[i],ret,newal,i+1);
            helper(n,t,ret,al,i+1);
        }
        
        
    }
}
