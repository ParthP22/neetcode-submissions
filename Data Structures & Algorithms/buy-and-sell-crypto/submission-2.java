class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        for(int left = 0, right = 0; right < prices.length; right++){
            if(prices[right] <= prices[left]){
                left = right;
            }
            else{
                max = Math.max(max, prices[right] - prices[left]);
            }
        }

        return max;
    }
}
