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

class Solution {
public:
int ladderLength(string start, string end, unordered_set<string> &dict) {
  // Start typing your C/C++ solution below
  // DO NOT write int main() function
  if(dict.empty()) return 0;
  int strLen = (*(dict.begin())).size();
  if(start.size()!=end.size() || start.size() != strLen) return 0;
  if(start==end) return 1;

  int shortestLen=1;
  queue<string> curr_queue;
  unordered_map<string, bool> visited;

  curr_queue.push(start);
  visited[start]=true;

  while(!curr_queue.empty())
  {
    shortestLen++;
    queue<string> new_queue;

    while(!curr_queue.empty())
    {
      string curr=curr_queue.front();
      curr_queue.pop();
      for(int pos=0; pos<strLen; pos++) //iterate all positions in the word
      {
        for(char c='a'; c<='z'; c++)    //iterate all possible chars
        {
          if(c==curr[pos]) continue;

          string newWord=curr;
          newWord.replace(pos,1,1,c);

          if(newWord==end) return shortestLen;

          if(dict.count(newWord)==0) continue; //not in dict
          if(visited.count(newWord)) continue; //already visited

          new_queue.push(newWord);
          visited[newWord]=true;
        }//for a-z
      }//for pos
    }//while
    curr_queue = new_queue; //proceed to the next depth/level
  }
  return 0;
}
};
