class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> freq[b+1000] - freq[a+1000]);

        for(int num : nums){
            freq[num + 1000]++;
        }

        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0){
                maxHeap.offer(i-1000);
            }
        }

        int[] topFreq = new int[k];

        for(int i = 0; i < k; i++){
            topFreq[i] = maxHeap.poll();
        }

        return topFreq;
    }
}
