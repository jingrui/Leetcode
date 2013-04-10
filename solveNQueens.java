import java.util.ArrayList;


public class Solution {
  public static void main(String[] args){
		ArrayList<String[]> ret = solveNQueens(4);
		for (int i = 0; i < ret.size(); i++)
			for (int j = 0; j < ret.get(i).length; j++)
				System.out.println(ret.get(i)[j]);

	}
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        int [] a = new int[n+1];
        helper(n,1,a,ret);
        return ret;
    }
    public static boolean helper (int n, int cur,int [] ar,ArrayList<String[]> ret){
        if ( cur > n){
            String[] strbuf = new String[n];
            for (int i = 1; i <= n; i++){
                String str = "";
                for(int j = 1; j <= (ar[i]-1); j++)
                	str +=".";
                str += "Q";
                for(int j = ar[i]; j < n; j++)
                	str +=".";
                strbuf[i-1] = str;
            }
            ret.add(strbuf);
            return true;
        }
            
        for(int i = 1; i <= n; i++){
            if(check(cur,ar,i)){
                ar[cur] = i;
                if (helper(n,cur+1,ar,ret))
                    return true;
            }
        }
        return false;
    }
    public static boolean check(int cur,int[] ar,int j){
        for(int i = 1; i < cur; i++)
        	if ((ar[i] == j) || (Math.abs(cur-i) == Math.abs(j-ar[i])))
        		return false;    
        return true;
    }
}
