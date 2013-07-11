public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> tmp = new ArrayList<Integer>();
      for(int i = 0; i < num.length; i++)
			tmp.add(num[i]);
        return helper(tmp);
    }
    public ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> num) {
       ArrayList<ArrayList<Integer>> ret = null;
        ArrayList<ArrayList<Integer>> realret = new ArrayList<ArrayList<Integer>>();
        if(num.size() == 1){
            ArrayList<Integer> tmp = new ArrayList<Integer>(num);
            ret = new ArrayList<ArrayList<Integer>>();
            ret.add(tmp);
            return ret;
        }
        
        for(int i = 0; i < num.size(); i++){
            int tmp = num.get(i);
            num.set(i,num.get(0));
            num.set(0,tmp);
//            for(int j = 0; j < num.size(); j++)
//    			System.out.print(num.get(j));
//			System.out.println("\ni = "+i);
            ArrayList<Integer> copy = new ArrayList<Integer>(num);
            copy.remove(0);
            ret = helper(copy);
//            for(int k = 0; k < ret.size(); k++){
//    			for(int j = 0; j < ret.get(k).size(); j++)
//    				System.out.print("ret."+ret.get(k).get(j));
//    			System.out.println();
//    		}
            for(ArrayList<Integer> al : ret){
                al.add(0,num.get(0));
            }
//            for(int k = 0; k < ret.size(); k++){
//    			System.out.println("after");
//    			for(int j = 0; j < ret.get(k).size(); j++)
//    				System.out.print("ret."+ret.get(k).get(j));
//    			System.out.println("\n----------");
//    		}
            realret.addAll(ret);
        }
        return realret;
    }
}
