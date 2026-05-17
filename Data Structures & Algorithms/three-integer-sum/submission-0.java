class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1, k = nums.length - 1; j < k;){
                
                if(nums[i] + nums[j] + nums[k] == 0){
                    LinkedList<Integer> curr = new LinkedList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    ret.add(curr);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    continue;
                }
                if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                else{
                    k--;
                }
                
            }
        }
        return ret;
    }
}
