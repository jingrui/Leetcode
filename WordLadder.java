public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(start == end)    return 0;
        if(dict.size() == 0)    return 0;
        if(start.length() != end.length())  return 0;
        int len = start.length();
        
        int dis = 1;
        LinkedList<String> q = new LinkedList<String>();
        HashSet<String> visited  = new HashSet<String>();
        q.add(start);
        visited.add(start);
        
        while(!q.isEmpty()){
            
          dis++;
	        LinkedList<String> nq = new LinkedList<String>(q);
	        q = new LinkedList<String>();
	        while(!nq.isEmpty()){
	        	String word = nq.poll();
		        for(int i = 0; i < len; i++){
		            for(char j = 'a'; j<='z';j++){
		            	if(word.charAt(i) == j)	continue;
		                String nword = word.substring(0,i)+j+word.substring(i+1);
		                if(nword.equals(end))	return dis;
                        if(!dict.contains(nword))    continue;
		                if(visited.contains(nword))	continue;
		                
		                q.add(nword);
	                    visited.add(nword);
		            }
		        }
	        }
        }
        return 0;    
    }
}
