public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper("",0,0,2*n);
    }
    public ArrayList<String> helper(String str,int left,int index, int limit){
       ArrayList<String> ret = new ArrayList<String>();
//      System.out.println("left = "+left+",index = "+index+",limit = "+limit+",str = "+str);

        if(index >= limit){
//        	System.out.println("str = "+str);
            ret.add(str);
            return ret;
        }
        
        if(left < (limit-index)){
            ret.addAll(helper(str+"(",left+1,index+1,limit));
//    		System.out.println("after left, left = "+left+",index = "+index+",limit = "+limit+",str = "+str);
        }

        if(left > 0){
            ret.addAll(helper(str+")",left-1,index+1,limit));
//    		System.out.println("after right, left = "+left+",index = "+index+",limit = "+limit+",str = "+str);
        }
        return ret;
    }
}
