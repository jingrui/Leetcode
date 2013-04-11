public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        for( i = digits.length -1; i >= 0; i--){
            if(digits[i] == 9)
                digits[i] = 0;
            else{
                digits[i]+= 1;
                break;
            }
        }
        if (i < 0 ){
            int [] ret = new int[digits.length+1];
            for(int j = ret.length-1; j > 0; j--)
                ret[j] = digits[j-1];
            ret[0] = 1;
            return ret;
        }
        
        return digits;
    }
}
