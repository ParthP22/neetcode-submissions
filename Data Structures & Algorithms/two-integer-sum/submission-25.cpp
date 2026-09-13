class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> exists;

        for(int i = 0; i < nums.size(); i++){
            if(exists.find(target - nums[i]) != exists.end()){
                return {exists[target - nums[i]], i};
            }
            exists[nums[i]] = i;
        }

        return {-1, -1};
    }
};
