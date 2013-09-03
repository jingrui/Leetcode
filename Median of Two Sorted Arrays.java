public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if((A.length + B.length)%2 == 0)
	    	return (findK(A,B,(A.length+B.length)/2)+findK(A,B,(A.length+B.length)/2+1))/2;
	    else
	    	return findK(A,B,(A.length+B.length)/2+1);
	}
	public double findK(int A[],int B[],int k){
		int m = A.length, n = B.length;
		if(m > n)	return findK(B,A,k);
		if(m == 0)  return B[k-1];
		if(n == 0)	return A[k-1];
		if(k == 1)	return Math.min(A[0], B[0]);
		
		int amid = Math.min(k/2, m);
		int bmid = k - amid;
		
		if(A[amid-1] < B[bmid-1])
			return findK(Arrays.copyOfRange(A, amid, A.length),B,k-amid);
		else
			return findK(A,Arrays.copyOfRange(B, bmid, B.length),k-bmid);
	}
}
