class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> count;

        vector<vector<int>> freq(nums.size() + 1);

        for(int n : nums){
            count[n]++;
        }

        for(const auto& entry: count){
            freq[entry.second].push_back(entry.first);
        }

        vector<int> ret;

        for(int i = freq.size() - 1, j = 0; j < k; i--){
            for(int n = 0; n < freq[i].size(); n++){
                ret.push_back(freq[i][n]);
                j++;
            }
        }

        return ret;
    }
};
