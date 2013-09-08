public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
    	if(s.isEmpty()) return false;
		if(s.contains(" "))	return false;
		
		String[] sa = null;
		
		// check e
		if(s.contains("e")){
			if((checkfreq(s,'e') != 1)||(s.indexOf('e') == 0)||(s.indexOf('e') == s.length()-1))	
				return false;
			sa = s.split("e");
		}
		
    	// check sign
		if(sa != null){
			if(((sa[0] = checkSign(sa[0])) == "")||((sa[1] = checkSign(sa[1])) == ""))	
                return false;
		}else
			if((s = checkSign(s)) == "")    return false;
		

		// check .
		if(sa != null){
			if(sa[1].contains("."))	return false;
			if((sa[0] = checkDot(sa[0])) == "")	return false;
			s = sa[0].concat(sa[1]);
		}else
			if((s = checkDot(s)) == "")	return false;

		// check others
        for(char c : s.toCharArray())
        	if(!(c >= '0' && c <= '9'))
        		return false;
        return true;
	}
    public String checkDot(String s){
		if(s.contains(".")){
			if(checkfreq(s,'.') != 1)	return "";
			if((s.indexOf(".") == 0)&&(s.length() == 1))	return "";
			String[] sa = s.split("\\.");
			s = "";
			for(String str : sa)
				s = s.concat(str); 
		}
		return s;
	}
    public String checkSign(String s){
    	if(s.contains("+")||s.contains("-")){
			if(checkfreq(s,'+')+checkfreq(s,'-') !=1)	return "";
			if(s.contains("+")){
				if(s.indexOf("+")!=0)	return "";
				s = s.replace("+", "");
			}else{
				if(s.indexOf("-")!=0)	return "";
				s = s.replace("-", "");
			}
	        if(s.isEmpty()) return "";
		}
    	return s;
    }
	public int checkfreq(String s, char pattern){
		int count = 0;
		for(char c : s.toCharArray())
			if(c == pattern)	
				count++;
		return count;
	}    
}
