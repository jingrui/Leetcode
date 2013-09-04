public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        if(n == 0)  return ret;
        ret.add(1);
        for(int i = 2; i <= n; i++){
            int size = ret.size();
            for(int j = 0; j < size; j++)
                ret.add(ret.get(size-1-j));
            
            // add number
            for(int j = ret.size()/2; j < ret.size(); j++)
                ret.set(j,ret.get(j)+(int)Math.pow(2,i-1));
        }
        return ret;
    }
}
