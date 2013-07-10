// running time O(T.length), it is much clear
public class Solution {
    public int numDistinct(String S, String T) {
       int[] ar = new int[T.length()+1];
      ar[ar.length-1] = 1;
		for (int i = S.length()-1; i >= 0; --i) 
            for (int j = 0; j < T.length(); ++j)
                ar[j] += (S.charAt(i)==T.charAt(j)?1:0)*ar[j+1];
		return ar[0];
    }
}


// dp O(T.length x S.length)
public class Solution {
    public int numDistinct(String S, String T) {
        if(S.length() == 0) return 0;
        
        int[][] ar = new int[T.length()+1][S.length()+1];
        for(int i = 0; i < ar.length; i++)
            ar[i][ar[0].length-1] = 0;        
        for(int i = 0; i < ar[0].length; i++)
          ar[T.length()][i] = 1;
        
        for(int i = ar[0].length-1; i >= 0; i--)
        	for(int j = ar.length-2; j >= 0; j--){
                String stmp = S.substring(i);
                String ttmp = T.substring(j);

                if(ttmp.length() > stmp.length()){
                    ar[j][i] = 0;
                    continue;
                }
                int index = stmp.indexOf(ttmp.charAt(0));
                if(index == -1) {
                    ar[j][i] = 0;
                    continue;
                }
                ar[j][i] = ar[j][i+index+1]+ar[j+1][i+index+1];
            }
        return ar[0][0];
    }
}

// backtracking
public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(T.length() == 0) return 1;
        if(S.length() < T.length()) return 0;
        int index = S.indexOf(T.charAt(0));
        if(index == -1) return 0;
        return numDistinct(S.substring(index+1),T.substring(1))+numDistinct(S.substring(index+1),T);
    }
}
