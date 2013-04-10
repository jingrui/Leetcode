public class Solution {
    public int maxSubArray(int[] A) {
        int sum = A[0];
        int max = A[0];
        
        for (int i = 1; i < A.length; i++){
            if(A[i] >= 0){
                if (sum < 0)
                    sum = A[i];  
                else
                    sum += A[i];
            }else{
                if (A[i] > sum)
                    sum = A[i];
                else 
                    sum += A[i];
            }
            max = (max > sum)? max:sum;
        }
        return max;
    }
}
