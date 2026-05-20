class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int firstZeroIndex = 0;
        int totalProduct = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                firstZeroIndex = i;
                zeroCount++;
            }
            else{
                totalProduct *= nums[i];
            }
        }

        if(zeroCount > 1){
            return new int[nums.length];
        }
        else if(zeroCount == 1){
            int[] ret = new int[nums.length];
            ret[firstZeroIndex] = totalProduct;
            return ret;
        }
        else{
            int[] ret = new int[nums.length];
            for(int i = 0; i < nums.length;  i++){
                ret[i] = totalProduct / nums[i];
            }

            return ret;
        }

    }
}  
