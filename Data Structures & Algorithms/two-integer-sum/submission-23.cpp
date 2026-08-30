class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();

        unordered_map<int,int> prevMap;

        for(int i = 0; i < n; i++){
            if(prevMap.find(target - nums[i]) != prevMap.end()){
                return { prevMap[target - nums[i]], i};
            }

            prevMap.insert({nums[i], i});
        }

        return {};
    }
};
