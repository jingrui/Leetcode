public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        rowIndex++;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        if(rowIndex <= 1)
            return ret;
        ret.add(0,0);
        ret.add(0);
        for(int i = 2; i <= rowIndex; i++){
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(0);
            for(int j = 0; j < i; j++)
                al.add(ret.get(j)+ret.get(j+1));
            al.add(0);
            ret = al;
        }
        ret.remove(0);
        ret.remove(ret.size()-1);
        return ret;
    }
}
