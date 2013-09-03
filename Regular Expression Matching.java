import java.util.Arrays;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "", b = ".*";
		//System.out.println(isMatch(a,b));
	}
	public static boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return helper(s,0,p,0);
    }
	public static boolean helper(String s,int si,String p,int pi){
		if(si == s.length()){
			if(pi == p.length()){
				//System.out.println("track 4\n");
				return true;
			}
			else{
				if(p.charAt(pi)=='.'){
					if((pi+1 < p.length())&&(p.charAt(pi+1) == '*'))
						return helper(s,si,p,pi+2);
					else{
						//System.out.println("track 5\n");
						return false;
					}
				}
				else if(p.charAt(pi) == '*'){
					//System.out.println("track 6\n");
					return helper(s,si,p,pi+1);
				}
				else if(((pi+1) < p.length())&&(p.charAt(pi+1)=='*')){
					//System.out.println("track 7\n");
					return helper(s,si,p,pi+2);
				}
				else{
					//System.out.println("track 8\n");
					return false;
				}
			}
		}
		if(pi == p.length())	return false;
		
		//System.out.println("s["+si+"]="+s.charAt(si));
		//System.out.println("p["+pi+"]="+p.charAt(pi));

		if((s.charAt(si) == p.charAt(pi))||(p.charAt(pi)=='.'))
		{
//			//System.out.println("pi+1="+(pi+1)+", p.length()="+p.length());
			if(pi+1 < p.length()){
				if(p.charAt(pi+1) !='*'){
					return helper(s,si+1,p,pi+1);
				}else{
					//System.out.println("track 0\n");
					return helper(s,si,p,pi+2)||helper(s,si+1,p,pi+1);
				}
			} else{
				return helper(s,si+1,p,pi+1);
			}
		}
		else if(p.charAt(pi) == '*'){
			//System.out.println("track 1\n");
			return helper(s,si,p,pi-1)||helper(s,si,p,pi+1);
		}
		else
		{
			if(((pi+1) < p.length())&&(p.charAt(pi+1)=='*')){
				//System.out.println("track 2\n");
				return helper(s,si,p,pi+2);
			}
			else{
				//System.out.println("track 3\n");
				return false;
			}
		}
	}
}
