// dp
// O(n^n) space and time

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
