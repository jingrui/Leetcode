//Given two numbers represented as strings, return multiplication of the numbers as a string.
//Note: The numbers can be arbitrarily large and are non-negative.
//
public class Solution {
    public String multiply(String num1, String num2) {
    String ret = "";
        Integer n1[] = new Integer[num1.length()];
      Integer n2[] = new Integer[num2.length()];
	    for(int i = n1.length-1; i >= 0;i--)
	       n1[n1.length-1-i] = Integer.parseInt(num1.substring(i,i+1));
	    for(int i = n2.length-1; i >= 0;i--)
	        n2[n2.length-1-i] = Integer.parseInt(num2.substring(i,i+1));
	 	
	    int n[] = new int[n1.length+n2.length];
	    for(int i = 0; i < n1.length ;i++)
	        for(int j= 0; j < n2.length;j++)
	           n[i+j] += n1[i]*n2[j];
	       
	    for(int i = 0;i < n.length; i++){
	       if (n[i] > 9)
	           n[i+1]+=n[i]/10;
	       ret = n[i]%10 + ret;
	    }
	    int i = 0;
	    while(i < ret.length())
	    	if (ret.charAt(i) =='0')
	    		i++;
	    	else 
	    		break;
	    ret = ret.substring(i,ret.length());
	    return ret.isEmpty()? "0":ret;
    }
}
