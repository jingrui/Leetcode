// Work with Duplicate, OK for small input, but Time exceeded for large input
import java.util.Iterator;
public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character,HashSet<Integer>> hm 
            = new HashMap<Character,HashSet<Integer>>();
        int t = T.length(), num = 0;
        for(int i = 0; i < T.length(); i++){
            if (!hm.containsKey(T.charAt(i))){
                HashSet<Integer> h = new HashSet<Integer>();
                h.add(-1);
                hm.put(T.charAt(i),h);
            } else {
                HashSet<Integer> h = hm.get(T.charAt(i));
                h.add(0-(h.size()+1));
                hm.put(T.charAt(i),h);
            }
        }
        
        int dist = Integer.MAX_VALUE;
        int s = 0, e = 0;
        for(int i = 0; i < S.length(); i++){
            char cur = S.charAt(i);
            if(hm.containsKey(cur)){
                // if new char
            	HashSet<Integer> h = hm.get(cur);
            	Iterator<Integer> it = h.iterator();
            	int a = 0;
            	int min = Integer.MAX_VALUE;
            	while(it.hasNext()){
            		a = it.next();
            		min = Math.min(a,min);
            		if(a < 0){
            			num++;
            			h.remove(a);
            			h.add(i);
            			break;
            		}
            	}
            	// already have it, then update the min index
            	if (a >= 0){
            		h.remove(min);
            		h.add(i);
            	}
            	
                hm.put(cur,h);                
                // if not have all char yet
                if (num < t)
                    continue;
                
                // if already have all
                if (num == t){
                    // find the max and min of the value set
                    int Amin = findmin(hm);
                    int Amax = findmax(hm);
                    if ((Amax-Amin+1) < dist){
                        dist = Amax-Amin+1;
                        s = Amin;
                        e = Amax;
                    }
                }
            }
        }
        if (num < t)    return "";
        return S.substring(s,e+1);
    }
	public int findmin(HashMap<Character,HashSet<Integer>> hm ){
		int min = Integer.MAX_VALUE;
		for(char c : hm.keySet()){
			int tmin = Integer.MAX_VALUE;
			HashSet<Integer> h = hm.get(c);
			Iterator<Integer> it = h.iterator();
        	while(it.hasNext())
        		tmin = Math.min(it.next(),tmin);
        	min = Math.min(min, tmin);
		}
		return min;
	}
	public int findmax(HashMap<Character,HashSet<Integer>> hm ){
		int max = Integer.MIN_VALUE;
		for(char c : hm.keySet()){
			int tmax = Integer.MIN_VALUE;
			HashSet<Integer> h = hm.get(c);
			Iterator<Integer> it = h.iterator();
        	while(it.hasNext())
        		tmax = Math.max(it.next(),tmax);
        	max = Math.max(max, tmax);
		}
		return max;
	}
}

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
