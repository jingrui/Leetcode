// this method is good for small input but time limit for large test case
// basic idea: from the highest to lowest, find the difference between this height with the second highest
// multiply height difference by the distance differece;
// then lower this highest to the second highest height and repeat
public class Solution {
    public int trap(int[] A) {
    if (A.length == 0) return 0;
        int ret = 0;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
        for(int i = 0; i < A.length; i++){
            if(!hm.containsKey(A[i])){
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(i);
                hm.put(A[i],al);
            } else 
                hm.get(A[i]).add(i);
        }

        Integer[] keyar =  new Integer[hm.keySet().size()];
        int k = 0;
        for(Integer key : hm.keySet())
        	keyar[k++] = key;
        
        Arrays.sort(keyar,Collections.reverseOrder());	// height
        int i = 0;
        while (i < keyar.length){ // not when level = 0
        	if (keyar[i] == 0) break;
        	ArrayList<Integer> v =  hm.get(keyar[i]);// get the index of the highest
        	Collections.sort(v); 
        	for (int j = 0; j <= v.size()-2; j++)
        		ret += (v.get(j+1)-v.get(j)-1)*(keyar[i]-((i+1) >= keyar.length? 0 : keyar[i+1]));
    
        	i++;
        	// update the next highest
    		  if (i < keyar.length)
    			  for (int j = 0; j < v.size(); j++)
    			  	hm.get(keyar[i]).add(v.get(j));
        }
        return ret;
    }
}
