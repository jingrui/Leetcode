public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[n+1];
        ret[n] = 1;
        ret[n-1] = 1;
        for(int i = n-2; i >=0; i--)
            ret[i] = ret[i+1]+ret[i+2];
        return ret[0];
    }
    
}
