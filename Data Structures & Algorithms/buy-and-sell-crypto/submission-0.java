class Solution {
    public int maxProfit(int[] prices) {

        int mProfit = 0;
        int buy = prices[0];
        for(int i=1;i<prices.length;i++) {
           mProfit = Math.max(mProfit, (prices[i]-buy));
           buy = Math.min(buy, prices[i]);
        }
        return mProfit;
        
    }
}
