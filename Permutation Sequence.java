public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
            al.add(i);
            
        String ret = "";
        int remainder;
        k--;
        for(int i = 1; i < n; i++){
            remainder = factorial(n-i);
            ret +=  al.get(k / remainder);
            al.remove(k / remainder);
            k = k % remainder;
        }
        ret += al.get(0);
        return ret;
    }
    public int factorial(int n){
        if(n == 1)  return 1;
        return n*factorial(n-1);
    }
}
