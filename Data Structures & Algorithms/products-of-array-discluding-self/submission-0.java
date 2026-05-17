class Solution {
    public int[] productExceptSelf(int[] nums) {

        int zeroIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(zeroIndex == -1){
                    zeroIndex = i;
                }
                else{
                    return new int[nums.length];
                }   
            }
        }

        int totalProduct = 1;
        for(int num : nums){
            if(num != 0){
                totalProduct *= num;
            }
        }

        if(zeroIndex != -1){
            int[] ret = new int[nums.length];
            ret[zeroIndex] = totalProduct;
            return ret;
        }

        

        for(int i = 0; i < nums.length; i++){
            nums[i] = (totalProduct / nums[i]);
        }

        return nums;
    }
}  
