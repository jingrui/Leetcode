// fast
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length == 0)   return 0;
        int dp[] = new int[s.length+1];
        dp[0] = 1;
        
        for(int i = 0; i < s.length; i++){
            if(s.charAt(i) != '0')
                dp[i+1] += dp[i];
            if((i >= 1)&&((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2'))&&(s.charAt(i) <= '6'))
                dp[i+1] += dp[i-1];
        }
        return dp[dp.size()-1];
    }
}


// slow
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0)  return 0;
        return helper(s);
    }
    public int helper(String s){
        if(s.length() == 0)  return 1;

        if (((s.charAt(0) -'0') >= 1) && ((s.charAt(0) -'0') <= 9)){
            if(s.length() == 1)  return 1;
            if((s.charAt(0) -'0')*10+(s.charAt(1) -'0') <= 26 )
                return helper(s.substring(1))+helper(s.substring(2));
            else
                return helper(s.substring(1));
        }else return 0;
    }
}
