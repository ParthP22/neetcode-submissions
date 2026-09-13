class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_set<int> exists;

        for(int i = 0; i < nums.size(); i++){
            if(exists.contains(nums[i])){
                return true;
            }
            exists.insert(nums[i]);
        }

        return false;
    }
};