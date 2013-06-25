//Palindrome Partitioning II
// small is good, not fast enough for large
public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return minCutHelper(s);
    }
    
    public int minCutHelper(String s){
        // 
        if (isPalind(s))
            return 0;
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < s.length(); i++){
            min = Math.min(minCutHelper(s.substring(0,i))+minCutHelper(s.substring(i))+1,min);
        }
        return min;
    }
    public boolean isPalind(String s){
        if (s.length() == 0)    return true;
        for(int i = 0; i <= s.length()/2; i++){// 2:0,1     3:0,1,2
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
