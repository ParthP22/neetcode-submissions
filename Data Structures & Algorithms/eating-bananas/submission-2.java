class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Integer.MAX_VALUE;
        int left = 1;
        int min = 0;

        while(left <= right){
            int k = (right - left)/2 + left;
            int totalTime = 0;

            for(int pile : piles){
                totalTime += Math.ceil((double)(pile) / k);
            }

            if(totalTime <= h){
                min = k;
                right = k - 1;
            }
            else{
                left = k + 1;
            }
        }

        return min;
    }
}
