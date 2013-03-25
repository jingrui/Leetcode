// Given an unsorted integer array, find the first missing positive integer.
// Your algorithm should run in O(n) time and uses constant space.

// main idea: check if 1, something in the middle(fisrt missing), or the next to Max value(if array is all from 1 to max)
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Integer> hm = new HashSet<Integer>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < A.length; i++){
            if (A[i] <= 0 ) continue;
            min = A[i] < min ? A[i] : min;
            max = A[i] > max ? A[i] : max;
            hm.add(A[i]);
        }
        int ret = -1;
        for(int i = min; i <= max; i++)
            if (!hm.contains(i)){
                ret = i;
                break;
            }
                
        if (min != 1) return 1;
        if (ret != -1) return ret;
        return max+1;
    }
}
