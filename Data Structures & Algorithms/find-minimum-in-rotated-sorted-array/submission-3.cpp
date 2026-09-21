class Solution {
public:
    int findMin(vector<int> &nums) {
        int left = 0;
        int right = nums.size() - 1;

        //int min = INT_MAX;

        while(left <= right){
            int mid = (right - left)/2 + left;
            //min = std::min(min, nums[mid]);
            if(nums[mid] >= nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return nums[right];
    }
};
