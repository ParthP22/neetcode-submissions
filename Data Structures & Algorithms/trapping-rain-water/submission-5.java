class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int water = 0;

        for(int left = 0, right = height.length - 1; left < right; ){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            }
            else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        
        return water;
    }
}
