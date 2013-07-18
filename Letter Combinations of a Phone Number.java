public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer,ArrayList<Character>> hm = new  HashMap<Integer,ArrayList<Character>>();
        for(int i = 2; i <= 6; i++){
            ArrayList<Character> tmp = new ArrayList<Character>();
            tmp.add((char) ((i-2)*3+'a'));
            tmp.add((char) ((i-2)*3+'b'));
            tmp.add((char) ((i-2)*3+'c'));
            hm.put(i,tmp);
        }
        ArrayList<Character> tmp = new ArrayList<Character>();
        tmp.add('p');
        tmp.add('q');
        tmp.add('r');
        tmp.add('s');
        hm.put(7,tmp);

        tmp = new ArrayList<Character>();
        tmp.add('t');
        tmp.add('u');
        tmp.add('v');
        hm.put(8,tmp);
        
        tmp = new ArrayList<Character>();
        tmp.add('w');
        tmp.add('x');
        tmp.add('y');
        tmp.add('z');
        hm.put(9,tmp);
        return helper("",hm,digits);
    }
    public ArrayList<String> helper(String cur, 
        HashMap<Integer,ArrayList<Character>> hm, String digits){
            ArrayList<String> ret = new ArrayList<String>();
            if(digits.length() == 0){
                ret.add(cur);
                return ret;
            }
            for(int i = 0; i < hm.get(digits.charAt(0)-'0').size(); i++)
                ret.addAll(helper(cur+hm.get(digits.charAt(0)-'0').get(i),hm,digits.substring(1)));
            return ret;
    }
}
