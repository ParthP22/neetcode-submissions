class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<>();
        }

        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }
        
        int[] ret = new int[k];

        for(int i = bucket.length - 1, j = 0; i >= 0 && j < k; i--){
            for(int n = 0; n < bucket[i].size(); n++){
                ret[j] = bucket[i].get(n);
                j++;
            }
        }

        return ret;
    }
}
