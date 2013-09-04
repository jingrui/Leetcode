public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if((s.length() == 1)||(s.length() == 0))  return 1;
        if((s.charAt(0) -'0')*10+(s.charAt(1) -'0') <= 26 )
            return numDecodings(s.substring(1))+numDecodings(s.substring(2));
        else
            return numDecodings(s.substring(1));
    }
}
