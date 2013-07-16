public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[2];
        double[] a = new double[A.length];
        for(int i = 0; i < A.length; i++)
            a[i] = (double)A[i];
        double t = (double)target;
        ret[0] = helper(a,t - 0.1);
        ret[1] = helper(a,t + 0.1);
        //System.out.println(ret[0]+", "+ret[1]);
		
		    // calibration
        if((ret[0]-1 >= 0)&&(A[ret[0]-1] == target))	ret[0]--;
        else if (A[ret[0]] == target)	;
        else if ((ret[0]+1 < A.length)&&(A[ret[0]+1] == target))	ret[0]++;
        else{
        	ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
            
        if((ret[1]+1 < A.length)&&(A[ret[1]+1] == target))	ret[1]++;
        else if (A[ret[1]] == target)	;
        else if ((ret[1]-1 >= 0)&&(A[ret[1]-1] == target))	ret[1]--;
        else{
        	ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        return ret;
    }
    public int helper(double[] a, double t){
        int s = 0, e = a.length-1;
        int mid = (s+e)/2;
        while(e >= s){
            mid = (s+e)/2;
            if(a[mid] > t)  e = mid-1;
            else            s = mid+1;
        }
        return mid;
    }
}
