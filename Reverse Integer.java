public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign = (x >=0)?1:-1;
        x = Math.abs(x);
        int ret = 0;
        while(x != 0){
            ret = ret*10+x%10;
            x = x/10;
        }
        return ret*sign;
    }
}
