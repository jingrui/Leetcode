public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        helper(num,0,new ArrayList<Integer>(),ret);
        ArrayList<ArrayList<Integer>> retAL = new ArrayList<ArrayList<Integer>>();
        Iterator<ArrayList<Integer>> it = ret.iterator();
        while(it.hasNext())
            retAL.add(it.next());
        return retAL;
    }
    public void helper(int[] n,int index,ArrayList<Integer> cur,HashSet<ArrayList<Integer>> ret){
    	if(index == n.length-1){
    		cur.add(n[index]);
    		ret.add(cur);
    		return;
    	}
    	
    	for(int i = index; i < n.length; i++){
    		int[] copy = new int[n.length];
    		System.arraycopy(n, 0, copy, 0, n.length);
    		ArrayList<Integer> curCopy = new ArrayList<Integer>(cur);
    		
    		swap(copy,i,index);
    		curCopy.add(copy[index]);
    		helper(copy,index+1,curCopy,ret);
    	}
    }
    public void swap(int[] c,int i, int j){
    	int tmp = c[i];
    	c[i] = c[j];
    	c[j] = tmp;
    }
}
