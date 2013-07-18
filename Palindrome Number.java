public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String str = Integer.toString(x);
        while(str.length() > 1){
            if(str.charAt(0) != str.charAt(str.length()-1))
              return false;
        	str = str.substring(1,str.length()-1);
        }
		return true;
    }
}
