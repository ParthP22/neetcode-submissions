class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];

        while(true){
            if(fast == slow){
                break;
            }

            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        int slow2 = 0;
        
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];

            if(slow == slow2){
                return slow;
            }
        }
        
    }
};
