// O(n) running time
// Work with Duplicate, OK for small input, but Time exceeded for large input
public class Solution {
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
        PriorityQueue<Integer> all = new PriorityQueue<Integer>();
        for(int i = 0; i < S.length(); i++){
        	char cur = S.charAt(i);
            if(hm.containsKey(cur)){
            	PriorityQueue<Integer> h = hm.get(cur);
            	h.add(i);
            	all.add(i);
                hm.put(cur,h);
                int polled = h.poll();
                all.remove(polled);
                // if new char
            	if(polled == -1)	num++;
            	
                // if not have all char yet
                if (num < t)	continue;
//                System.out.println("i = "+i+",num = "+num);
                // if already have all
                if (num == t){
                    // find the max and min of the value set
                    Amin = all.peek();
//                    Object[] a = all.toArray();
//                    for(int j = 0; j < a.length;j++)
//                        System.out.println("a["+j+"]="+a[j]);

                    Amax = Collections.max(all);
//                    System.out.println("max = "+Amax+", min = "+Amin);
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
