// this is good if T does not have duplicates
public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        int t = T.length(), num = 0;
        for(int i = 0; i < T.length(); i++){
            hm.put(T.charAt(i),-1);
        }
        
        int dist = Integer.MAX_VALUE;
        int s = 0, e = 0;
        for(int i = 0; i < S.length(); i++){
            char cur = S.charAt(i);
            if(hm.containsKey(cur)){
                // if new char
                if(hm.get(cur) == -1)
                    num++;
                hm.put(cur,i);
                // if not have all char yet
                if (num < t)
                    continue;
                
                // if already have all
                if (num == t){
                    // find the max and min of the value set
                    int min = Collections.min(hm.values());
                    int max = Collections.max(hm.values());
                    if ((max-min+1) < dist){
                        dist = max-min+1;
                        s = min;
                        e = max;
                    }
                }
            }
                    
        }
        if (num < t)    return "";
        return S.substring(s,e+1);
    }
}
