public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character,Integer> need = new HashMap<Character,Integer>();
        HashMap<Character,Integer> read = new HashMap<Character,Integer>();
        for(char c : T.toCharArray()){
            if(need.containsKey(c))
        		need.put(c,need.get(c)+1);
        	else
        		need.put(c, 1);
        }
        
        String ret = "";
        int min = Integer.MAX_VALUE;
        int read_char_from_t = 0;
        int begin = 0;
        for(int i = 0; i < S.length(); i++){
        	char c = S.charAt(i);
            if(!need.containsKey(c))	continue;
        	read.put(c, read.containsKey(c)?read.get(c)+1:1);
        	if(read.get(c) <= need.get(c))
        		read_char_from_t++;
        	
        	if(read_char_from_t == T.length()){
                char cur = S.charAt(begin);
        		while((!read.containsKey(cur))||(read.get(cur) > need.get(cur))){
               		if(read.containsKey(cur)&&(read.get(cur) > need.get(cur)))
           				read.put(cur, read.get(cur)-1);
           			begin++;
           			cur = S.charAt(begin);
       			}
        		
        		if(min > (i-begin+1)){
        			min = Math.min(min,i-begin+1);
        			ret = S.substring(begin,i+1);
        		}
        		read.put(cur,read.get(cur)-1);
        		read_char_from_t--;
        		begin++;
        	}
        }
        
        return ret;        
    }
}
