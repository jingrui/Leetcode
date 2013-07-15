public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int interval = 0;
        for(int i = 1; i < A.length;i++){
            if(A[i] == A[i-interval-1])
                interval++;
            else
                A[i-interval] = A[i];
        }
        return A.length - interval;
    }
}
