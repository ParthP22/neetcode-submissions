class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int pile : piles){
            max = Math.max(max,pile);
        }
        
        int left = 1;
        int right = max;
        int k = 0;
        int minK = max;
        while(left <= right){
            k = left + (right - left)/2;
            int totalTime = 0;
            for(int pile : piles){
                totalTime += (int)Math.ceil((double)pile/k);
            }
            if(totalTime <= h){
                minK = k;
                right = k - 1;
            }
            else{
                left = k + 1;
            }
        }
        return minK;
    }
}
