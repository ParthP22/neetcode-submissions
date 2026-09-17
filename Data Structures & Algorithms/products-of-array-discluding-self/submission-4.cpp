class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int zeroCount = 0;
        int zeroIndex = 0;
        int totalProduct = 1;

        for(int i = 0; i < nums.size(); i++){
            if(nums[i] != 0){
                totalProduct *= nums[i];
            }
            else{
                zeroCount++;
                zeroIndex = i;
            }
        }

        if(zeroCount > 1){
            vector<int> ret (nums.size());
            return ret;
        }
        if(zeroCount == 1){
            vector<int> ret (nums.size());
            ret[zeroIndex] = totalProduct;
            return ret;
        }
        else{
            vector<int> ret(nums.size());
            for(int i = 0; i < nums.size(); i++){
                ret[i] = totalProduct / nums[i];
            }
            return ret;
        }
    }
};
