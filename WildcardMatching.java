// dp
// O(n^n) space and time
// however, time limit exceed for large input test
// how to optimize?
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean ret[][] = new boolean[s.length()+1][p.length()+1];
    	ret[s.length()][p.length()] = true;
		for(int i = p.length()-1; i >=0 ; i--)
			if ((p.charAt(i) == '*')&&(ret[s.length()][i+1]))
				ret[s.length()][i] = true;
			else
				ret[s.length()][i] = false;

		for(int i = 0; i < s.length(); i++)
			ret[i][p.length()] = false;
		
		for(int i = p.length()-1; i>= 0; i--)
			for(int j = s.length()-1; j >= 0; j--){
				if(s.charAt(j) == p.charAt(i) || p.charAt(i) == '?')
					ret[j][i] = ret[j+1][i+1];

				if(p.charAt(i) == '*')
					for(int k = j; k <= s.length(); k++){
						if (ret[k][i+1]){
							ret[j][i] = true;
							break;
						}
						ret[j][i] = false;
					}
			}
		return ret[0][0];
    }
}
// recursion
public class Solution {
	public boolean isMatch(String s, String p) {
		if (s.isEmpty() && p.isEmpty())
			return true;
		if (s.isEmpty() || p.isEmpty())
			return false;
		if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')
			return isMatch(s.substring(1,s.length()),p.substring(1,p.length()));
		
		if(p.charAt(0) == '*')
			for(int i = 1 ; i <= s.length(); i++)
				if(isMatch(s.substring(i,s.length()),p.substring(1,p.length())))
					return true;
		return false;
    }
}
