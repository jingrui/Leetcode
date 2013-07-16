public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int s = 0, e = A.length-1,mid,t = target;
        while(e >= s){
            mid = (s+e)/2;
            if(A[mid] == t)    return mid;
            if((mid+1 < A.length)&&(A[mid+1] == t)) return mid+1;

            if(A[s] < A[mid]){
                if((A[s] <= t)&&(t < A[mid]))   e = mid-1;
                else                            s = mid+1;
            }else if(A[mid] < A[e]){
                if((A[mid] < t)&&(t <= A[e]))   s = mid+1;
                else                            e = mid-1;
            }else{
                s++;
                e--;
            }
        }
        return -1;
    }
}
