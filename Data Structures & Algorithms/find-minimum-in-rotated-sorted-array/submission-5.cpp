class Solution {
public:
    // (9/21/2026: @4:55 PM EDT)
    // I'm not sure why this solution works.
    // In the posted solution, the loop's condition
    // does not consider left and right being equal,
    // and the element returned at the end is nums[left].
    // I messed around a bit and found that you can
    // return nums[right] as the final solution with
    // or without left == right being checked in the
    // loop's condition. However, if you do make the
    // loop's condition left <= right instead of
    // left < right, then returning nums[left] does not
    // work, only nums[right] does.
    // No idea why it's like this, but I'll investigate
    // it further... if I remember to.
    int findMin(vector<int> &nums) {
        int left = 0;
        int right = nums.size() - 1;

        while(left <= right){
            int mid = (right - left)/2 + left;
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
