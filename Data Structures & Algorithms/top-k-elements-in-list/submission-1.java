class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[][] freq = new int[2001][2];
        
        
        for(int i = 0; i < nums.length; i++){
            freq[nums[i] + 1000][0] = nums[i];
            freq[nums[i] + 1000][1]++;
        }

        Arrays.sort(freq, (a,b) -> b[1] - a[1]);
        
        int[] ret = new int[k];
        for(int i = 0; i < k; i++){
            ret[i] = freq[i][0];
        }
        return ret;

        /*
        int[] freq = new int[2001];
        
        
        for(int i = 0; i < nums.length; i++){
            freq[nums[i] + 1000]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freq[b + 1000] - freq[a + 1000]);

        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0){
                pq.offer(i - 1000);
            }
        }
        int[] ret = new int[k];
        for(int i = 0; i < k; i++){
            ret[i] = pq.poll();
        }
        return ret;
        */
    }
}
