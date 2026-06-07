class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = piles[0];

        for(int pile : piles){
            right = Math.max(pile, right);
        }

        int left = 1;
        int minK = 0;

        while(left <= right){
            int k = (right - left)/2 + left;

            int totalTime = 0;
            for(int pile : piles){
                totalTime += Math.ceil((double)pile/k);
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
