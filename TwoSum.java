public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[2];
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++)
            if(hs.containsKey(numbers[i]))
                hs.put(numbers[i],hs.get(numbers[i])+1);
            else
                hs.put(numbers[i],1);
        
        for(int i = 0; i < numbers.length; i++){
            int second = target - numbers[i];
            if(hs.containsKey(second)){
                if(second == numbers[i])
                    if(hs.get(numbers[i]) <= 1)
                        continue;                        
                
                // if not equal or have 2 copy
                ret[0] = i+1;
                for(int j = i+1; j < numbers.length; j++)
                    if(numbers[j] == second){
                        ret[1] = j+1;
                        return ret;
                    }
            }
        }
        
        return null;
    }
}
