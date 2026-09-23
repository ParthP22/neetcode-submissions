class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while(left <= right){
            int mid = (right - left)/2 + left;

            if(nums[mid] == target){
                return mid;
            }

            // We check the left portion of the array
            if(nums[left] <= nums[mid]){
                if(nums[mid] < target || nums[left] > target){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            // We check the right portion of the array
            else{
                if(nums[mid] > target || nums[right] < target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
};
