public class Solution {
    public String addBinary(String a, String b) {
        String ret = "";
        char[] f = a.toCharArray();
        char[] s = b.toCharArray();
        int i = f.length-1;
        int j = s.length-1;
        int carry = 0;
        int f1,s1;
        while((i>=0)||(j>=0)){
            f1 = (i>=0)?f[i]:'0';
          s1 = (j>=0)?s[j]:'0';
        	//System.out.println("f1 = "+(char)f1+",s1 = "+(char)s1+",carry="+carry);
            char[] tmp = {(char)(((carry+f1-'0'+s1-'0')%2)+'0')};
            ret = new String(tmp) + ret;
            //System.out.println(ret);
            carry = (carry+(f1-'0')+(s1-'0')) /2;
            i--;
            j--;
        }
        if (carry!=0)
            ret  = "1"+ret;
        return ret;         
    }
}
