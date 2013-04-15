public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int h = 0, e = s.length()-1;
        while(true){
            while(h < e){
                if(isvalid(s.charAt(h)))
                    break;
                h++;
            }
            while(h < e){
                if(isvalid(s.charAt(e)))
                    break;
                e--;
            }
            if(h >= e)   return true;
            if(s.charAt(h) != s.charAt(e))  return false;
            h++;
            e--;
        }
    }
    public boolean isvalid(char in){
        if (((in >= 'a') && (in <='z')) || ((in >='0') &&(in <='9')))
            return true;
        return false;
    }
}
