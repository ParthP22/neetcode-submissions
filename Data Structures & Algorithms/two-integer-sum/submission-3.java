class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i],i);
            }
            else{
                return new int[]{map.get(target - nums[i]),i};
            }
        }
        return new int[]{-1,-1};


        /*
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
        */
    }
}
