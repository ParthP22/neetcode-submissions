class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int max = 0;

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 
                    map.getOrDefault(nums[i] - 1, 0) + 
                    map.getOrDefault(nums[i] + 1, 0) + 1
                );

                map.put(nums[i] - map.getOrDefault(nums[i] - 1, 0),
                    map.get(nums[i])
                );

                map.put(nums[i] + map.getOrDefault(nums[i] + 1, 0),
                    map.get(nums[i])
                );

                max = Math.max(max, map.get(nums[i]));
            }
        }

        return max;
    }
}
