public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        
        int buy = prices[0],profit = 0;
        boolean bought = true,sold = false;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]) // increasing
              sold =false;
                if(!bought){//not buy yet
                    buy = prices[i-1];
                    bought = true;
                }
            
            if(prices[i] < prices[i-1]){// decreasing
                bought = false;
                if(!sold){
                    profit += prices[i-1]-buy;
                    sold = true;
                }
                    
            }
        }
        if(!sold)
            profit+=prices[prices.length-1]-buy;
        return profit;
    }
}
