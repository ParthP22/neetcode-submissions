class Solution {
public:
    int maxArea(vector<int>& heights) {
        int maxArea = 0;

        for(int left = 0, right = heights.size() - 1; left < right;){
            if(heights[left] < heights[right]){
                maxArea = max(maxArea, heights[left] * (right - left));
                left++;
            }
            else{
                maxArea = max(maxArea, heights[right] * (right - left));
                right--;
            }
        }

        return maxArea;
    }
};
