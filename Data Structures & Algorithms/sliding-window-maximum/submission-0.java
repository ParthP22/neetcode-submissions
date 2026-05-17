class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        int right = 0;
        //int max = Integer.MIN_VALUE;

        for(; right < k - 1; right++){
            pq.offer(nums[right]);
            //max = pq.peek();
        }

        int[] ret = new int[nums.length - k + 1];
        for(int left = 0; right < nums.length; left++,right++){
            pq.offer(nums[right]);
            ret[left] = pq.peek();
            pq.remove(nums[left]);
        }

        return ret;
    }
}
