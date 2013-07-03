public class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int buyprice = Integer.MAX_VALUE;
        for(int i = 0; i < buy.length; i++){
            if(prices[i] < buyprice)
                buyprice = prices[i];
            buy[i] = buyprice;
        }
        
        int[] sel = new int[prices.length];
        int selprice = Integer.MIN_VALUE;
        for(int i = sel.length-1; i >= 0 ; i--){
            if(prices[i] > selprice)
                selprice = prices[i];
            sel[i] = selprice;
        }
        
        int diff = 0;
        for(int i = 0; i < buy.length; i++)
            diff = Math.max(sel[i]-buy[i],diff);
        return diff;
    }
}
