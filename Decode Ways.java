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
