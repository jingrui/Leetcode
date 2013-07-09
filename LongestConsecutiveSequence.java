public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ret = Integer.MIN_VALUE, max = 0, min  = 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < num.length; i++){
            if (hm.containsKey(num[i]))  continue;
            hm.put(num[i],1);
            if (hm.containsKey(num[i]-1)){
                max = num[i];
                min = num[i]-1-hm.get(num[i]-1)+1;
                // upper bound
                hm.put(max,hm.get(num[i]-1)+hm.get(num[i]));
                // lower bound
                hm.put(min, hm.get(max));
                
            }
            if(hm.containsKey(num[i]+1)){
                max = hm.get(num[i]+1)+(num[i]+1)-1;
                min = num[i]-hm.get(num[i])+1;    
                // upper bound
                hm.put(max,hm.get(num[i])+hm.get(num[i]+1));
                // lower bound
                hm.put(min, hm.get(max));
                
            }
        }
        for(Integer i : hm.values())
            ret = Math.max(i,ret);
        
        return ret;
        
    }
}
