public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        str = str.trim();
        if(str.isEmpty())   return 0;
        int sign = 1;
        int index = 0;
        if(str.charAt(0) == '+')
            index++;
        if(str.charAt(0) == '-'){
            index++;
            sign = -1;
        }
        while(str.charAt(index) == '0')
            index++;
        str = str.substring(index);
        index = 0;
        while((index<str.length())&&(str.charAt(index) >= '0')&&(str.charAt(index) <= '9'))
            index++;
        str = str.substring(0,index);
        if(str.isEmpty())   return 0;
        else
            if(sign*Long.parseLong(str)>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign*Long.parseLong(str)<=Integer.MIN_VALUE)
              return Integer.MIN_VALUE;
            return sign*Integer.parseInt(str);        
    }
}
