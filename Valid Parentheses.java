public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0)    return true;
        if (s.length() %2 != 0)  return false;
        HashMap<Character,Character> hm = new HashMap<Character,Character>();
        hm.put(']','[');
        hm.put(')','(');
        hm.put('}','{');     
        int i = 0;
        int left = 0;
        while(i < s.length()){
        	char cur = s.charAt(i);
        	if(hm.containsKey(cur)){
        		left--;
        		if((i-1)>=0){
        			char prev = s.charAt(i-1);
        			if(hm.get(cur) != prev)	return false;
        			s = s.substring(0,i-1)+s.substring(i+1);
        			i--;
        		}else	return false;
        	}else{
        		left++;
        		i++;
        	}
        }
        return (left == 0)? true:false;
    }
}
