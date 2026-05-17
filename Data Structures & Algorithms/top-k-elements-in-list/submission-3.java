class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];
        List<Integer>[] freqList = new List[nums.length + 1];

        for(int i = 0; i < nums.length+1; i++){
            freqList[i] = new ArrayList<>();
        }

        for(int num : nums){
            freq[num + 1000]++;
        }

        for(int i = 0; i < 2001; i++){
            freqList[freq[i]].add(i - 1000);
        }

        int[] topKFreq = new int[k];

        for(int i = nums.length, j = k - 1; i > 0 && j >= 0; i--){
            for(int m = 0; m < freqList[i].size(); m++){
                topKFreq[j] = freqList[i].get(m);
                j--;
            }
        }   
        return topKFreq;

    }
}
