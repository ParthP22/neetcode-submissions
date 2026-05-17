class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);

        for(int left = 0; left < nums.length; left++){
            
            if(nums[left] > 0){
                break;
            }

            if(left > 0 && nums[left - 1] == nums[left]){
                continue;
            }

            for(int mid = left + 1, right = nums.length - 1; mid < right;){
                if(nums[left] + nums[mid] + nums[right] == 0){
                    ArrayList<Integer> sum = new ArrayList<>();
                    sum.add(nums[left]);
                    sum.add(nums[mid]);
                    sum.add(nums[right]);

                    ret.add(sum);

                    mid++;
                    right--;

                    while(mid < right && nums[mid] == nums[mid - 1]){
                        mid++;
                    }
                }
                else if(nums[left] + nums[mid] + nums[right] > 0){
                    right--;
                }
                else{
                    mid++;
                }
            }
        }

        return ret;
    }
}
