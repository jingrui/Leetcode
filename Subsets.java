public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
      ArrayList<ArrayList<Integer>> ret = helper(0,S);
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
		return  ret;
	}
	public ArrayList<ArrayList<Integer>> helper(int cur, int[] S){
		if (cur ==  S.length){
			ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
			ret.add(new ArrayList<Integer>());
			return ret;
		}

		ArrayList<ArrayList<Integer>> ret = helper(cur+1,S);
		int size = ret.size();
		for(int i = 0; i < size; i++){
			ArrayList<Integer> nal = new ArrayList<Integer>(ret.get(i));
			nal.add(S[cur]);
			Collections.sort(nal);
			ret.add(nal);
		}
		return ret;
	}
}
