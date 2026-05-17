class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int zeroIndex = 0;
        int totalProduct = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
                zeroIndex = i;
            }
            else{
                totalProduct *= nums[i];
            }
        }

        int[] ret = new int[nums.length];
        if(zeroCount > 1){
            return ret;
        }
        else if(zeroCount == 1){
            ret[zeroIndex] = totalProduct;
            return ret;
        }
        else{
            for(int i = 0; i < ret.length; i++){
                ret[i] = totalProduct / nums[i];
            }
            return ret;
        }

    }
}  
