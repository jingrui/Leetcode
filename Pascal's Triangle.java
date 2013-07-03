public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret =  new ArrayList<ArrayList<Integer>>();
        for(int i = 1; i <= numRows; i++){
            ArrayList<Integer> al =  new ArrayList<Integer>();
            al.add(1);
            for(int j = 1; j < (i-1); j++){
                al.add(ret.get(i-2).get(j-1)+ret.get(i-2).get(j));
            }
            if(al.size() < i)
                al.add(1);
            ret.add(al);
        }
        return ret;
    }
}
