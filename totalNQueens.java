public class Solution {
     public int totalNQueens(int n) {
        int [] a = new int[n+1];
        return helper(n,1,a);
    }
    public int helper (int n, int cur,int [] ar){
        if (cur > n)
            return 1;
        
        int ret = 0;
        for(int i = 1; i <= n; i++)
            if(check(cur,ar,i)){
                ar[cur] = i;
                ret += helper(n,cur+1,ar);
            }
        return ret;
    }
    public boolean check(int cur,int[] ar,int j){
        for(int i = 1; i < cur; i++)
          if ((ar[i] == j) || (Math.abs(cur-i) == Math.abs(j-ar[i])))
        		return false;    
        return true;
    }
}
