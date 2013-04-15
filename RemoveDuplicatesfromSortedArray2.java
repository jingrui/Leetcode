public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2) return A.length;
        int writeto = 1;
        int cur = 1;
        int num = 1;
        while(cur < A.length){
            if(A[cur] == A[cur-1]){
                num++;
                if(num <= 2)
                    A[writeto++] = A[cur];
            }else{
                num = 1;
                A[writeto++] = A[cur];
            }
            cur++;
        }
        return writeto;
    }
}
