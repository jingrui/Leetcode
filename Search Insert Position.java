public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int s = 0, e = A.length-1, mid = (e+s)/2;
        while(e >= s){
            mid = (e+s)/2;
            if(A[mid] == target)    return mid;
            if(A[mid] > target)
                e = mid -1;
            else
                s = mid+1;
        }
        if(A[mid] > target) return mid;
        else                return mid+1;
    }
}
