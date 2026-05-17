class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }

        int left = 0;
        int right = 1;
        int maxProfit = 0;

        for(; right < prices.length; right++){
            while(prices[left] > prices[right]){
                left++;
            }

            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);

        }

        return maxProfit;
    }
}
