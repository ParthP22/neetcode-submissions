class Solution {
    public int trap(int[] height) {
        // I just took a look at NeetCode's Two-Pointer
        // solution for this for the first time ever.
        // I did a dry run in my head on the first test case
        // after I understood his algo and it just made
        // so much sense to me.
        // I immediately came to LeetCode to see if I could
        // reproduce the algorithm off the top of my head
        // based on my intuition that I gained from it,
        // and I got ALMOST on my first try. I copy and 
        // pasted my code from the if-block into the else-block,
        // so I left it as "right++", which was wrong the first
        // time. After making it "right--", I got it right.

        // Here is some of the intuition that I gained from when
        // I read NeetCode's solution: whenever you reach a new
        // max height, whether it's for the left or the right
        // pointer, you will always be adding zero to the sum.
        // This makes sense, because there are no bars before it
        // that would trap any water, since those previous bars
        // are of a shorter height than the current bar (which
        // we assume is the new max height).
        // However, when we move the pointers along and we end
        // up at a shorter bar than the current max, it means
        // the max bar will help trap water, since it blocks off
        // any water from escaping on one side, because the max
        // height bar is taller than the current bar.
        // I don't know if this explanation will still make 
        // sense in the future, but it makes perfect sense to me
        // right now.

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int water = 0;

        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax,height[left]);
                water += leftMax - height[left];
            }
            else{
                right--;
                rightMax = Math.max(rightMax,height[right]);
                water += rightMax - height[right];
            }
        }

        return water;
    }
}
