public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty()) return 0;
        int start = 0;
        int max = 1;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        hm.put(s.charAt(0),0);
        for(int i = 1; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i)))
              if(hm.get(s.charAt(i)) >= start)
                    start = hm.get(s.charAt(i))+1;
                
            hm.put(s.charAt(i),i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}
