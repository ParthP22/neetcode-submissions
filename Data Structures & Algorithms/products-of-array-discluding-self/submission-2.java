class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Count the number of zeros in nums.
        int zeroCount = 0;

        // Keep track of the last index where there was
        // a zero in nums.
        int zeroIndex = 0;

        // Do a product of all non-zero elements in nums.
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
        // If there is more than one zero in nums, then
        // the entire array will be 0, since anything
        // times 0 is 0.
        // For example, take [1,2,0,5,0,6].
        // At any index, the product of the whole array
        // except itself will be 0.
        if(zeroCount > 1){
            return ret;
        }

        // If there is exactly one zero, then everything
        // in the array will be zero except for the one
        // index in which zero occurs.
        // For example, take [1,2,0,5,6].
        // At any index, the product of the whole array
        // except itself will be 0, except for index 2,
        // since that is the only index where the element
        // is 0. This means the product of everything
        // except itself at index 2 is 1*2*5*6, which is
        // simply the product of all non-zero element in
        // nums.
        else if(zeroCount == 1){
            ret[zeroIndex] = totalProduct;
            return ret;
        }

        // Otherwise, there are no zeros in nums, which means
        // you can just take the totalProduct and divide by
        // nums[i] for each element. Note that we will never
        // get a decimal, since totalProduct in this case
        // is the product of every element in nums, which
        // means every element in nums will divide into the
        // total product.
        else{
            for(int i = 0; i < ret.length; i++){
                ret[i] = totalProduct / nums[i];
            }
            return ret;
        }

    }
}  
