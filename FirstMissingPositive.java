public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int up, low,max = 1;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < A.length; i++){
            if(!hm.containsKey(A[i])){
                hm.put(A[i],1);
                if(A[i] == max)   max++;
                if(hm.containsKey(A[i]-1)){
                    up = A[i];
                    low = (A[i]-1)-hm.get(A[i]-1)+1;
                    hm.put(low,hm.get(low)+1);
                    hm.put(up,hm.get(low));
                }
                if(hm.containsKey(A[i]+1)){
                    low = A[i]-hm.get(A[i])+1;
                    up = (A[i]+1)+hm.get(A[i]+1)-1;
                    hm.put(up,hm.get(low)+hm.get(up));
                    hm.put(low,hm.get(up));
                    if(max == A[i]+1){
                        max = up;
                        max++;
                    }
                }
            }
        }
        return max;
    }
}
