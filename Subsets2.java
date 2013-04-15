public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> ret = helper(0,num);
      	Collections.sort(ret, new Comparator<ArrayList<Integer>>(){
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				if (o1.size() < o2.size())	return -1;
				if (o1.size() > o2.size())	return 1;
				for(int i = 0; i < o1.size(); i++){
					if (o1.get(i)< o2.get(i))	return -1;
					if (o1.get(i)> o2.get(i))	return 1;
				}
				return 0;
			}});
        int i = 1;
        while(i < ret.size()){
            if (ret.get(i).equals(ret.get(i-1))){
                ret.remove(i);
                continue;
            }
            i++;
        }
		return  ret;
    }
    public ArrayList<ArrayList<Integer>> helper(int cur, int[] num){
        if(cur == num.length){
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        ArrayList<ArrayList<Integer>> ret = helper(cur+1,num);
        int size = ret.size();
        for(int i = 0; i < size; i++){
            ArrayList<Integer> al = new ArrayList<Integer>(ret.get(i));
            al.add(num[cur]);
            Collections.sort(al);
            ret.add(al);
        }
        return ret;
    }
}
