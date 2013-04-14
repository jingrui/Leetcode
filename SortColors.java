public class Solution {
    public void sortColors(int[] A) {
        int r = 0,w = 0,b = 0;
        for(int i = 0; i < A.length; i++){
            r += (A[i] == 0)? 1: 0;
            w += (A[i] == 1)? 1: 0;
            b += (A[i] == 2)? 1: 0;
        }
        int i = 0;
        while(i < r)
            A[i++] = 0;
        while(i <(r+w))
            A[i++] = 1;
        while(i < (r+w+b))
            A[i++] = 2;    
    }
}
