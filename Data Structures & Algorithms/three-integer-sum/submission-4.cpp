class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ret;

        sort(nums.begin(), nums.end());

        for(int i = 0; i < nums.size(); i++){
            // If the lowest possible number in this iteration
            // is greater than zero, then there do no exist any
            // more combinations that will give us a sum of 0.
            if(nums[i] > 0){
                break;
            }

            // If the current lowest possible number
            // is the same as the previous number, then
            // we increment this pointer to avoid 
            // duplicate triplets. 
            // Note: we must check i > 0, because if
            // i == 0, then nums[i - 1] will give us
            // an out of bounds error.
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // Start the left pointer at i + 1
            int left = i + 1;

            // The right pointer will always begin on
            // the final (largest) number in the array.
            int right = nums.size() - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum > 0){
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    ret.push_back({nums[i], nums[left], nums[right]});

                    left++;
                    right--;

                    // We skip all duplicate elements that the left
                    // pointer could encounter during this iteration.
                    // Notice that we don't need to check if left > 0,
                    // because left = (i + 1) > 0 always. 
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
            }

        }

        return ret;
    }
};
