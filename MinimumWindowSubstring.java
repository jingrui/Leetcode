// O(n) running time
// Work with Duplicate, OK for small input, but Time exceeded for large input
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Solution {
	public static void main(String[] args){
		System.out.println(minWindow("dsohniaulobaxywggcojkvxubzslwxpcqfjfnjzyxcbwczfibttmosgqsadqysuqyevlpumpynnamsipndbewjwqmzimsdcsjzdyvrntebtsvdijglnexjujkfvcizwryarvthoykjsfoaowodbloxwzctdmuafsczpvgdvqooxcqmygrbtgbpffkksekzymynigsdwitukmilsbomh", "pdovozpul"));
	}
	public static String minWindow(String S, String T) {
        HashMap<Character,PriorityQueue<Integer>> hm 
            = new HashMap<Character,PriorityQueue<Integer>>();
        int t = T.length(), num = 0;
        for(int i = 0; i < t; i++){
        	PriorityQueue<Integer> h;
            if (!hm.containsKey(T.charAt(i)))
            	h = new PriorityQueue<Integer>();
            else
            	h = hm.get(T.charAt(i));
            h.add(-1);
            hm.put(T.charAt(i),h);
        }
        
        int dist = Integer.MAX_VALUE;
        int s = 0, e = 0, Amin, Amax;
        for(int i = 0; i < S.length(); i++){
        	char cur = S.charAt(i);
            if(hm.containsKey(cur)){
            	PriorityQueue<Integer> h = hm.get(cur);
            	h.add(i);
                hm.put(cur,h);
                // if new char
            	if(h.poll() == -1)	num++;
            	              
                // if not have all char yet
                if (num < t)	continue;
                
                // if already have all
                if (num == t){
                    // find the max and min of the value set
                    Amin = findmin(hm);
                    Amax = findmax(hm);
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
	public static int findmin(HashMap<Character,PriorityQueue<Integer>> hm ){
		int min = Integer.MAX_VALUE;
		for(char c : hm.keySet()){
			PriorityQueue<Integer> h = hm.get(c);
        	min = Math.min(min, h.peek());
		}
		return min;
	}
	public static int findmax(HashMap<Character,PriorityQueue<Integer>> hm ){
		int max = Integer.MIN_VALUE;
		for(char c : hm.keySet()){
        	max = Math.max(max, Collections.max(hm.get(c)));
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
