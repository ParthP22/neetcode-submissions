class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int max_area = 0;
        int n = heights.size();

        // pair: index and height
        stack<pair<int,int>> stk; 

        for(int i = 0; i < n; i++){
            // This 'start' variable is used to extend the
            // rectangle that the current element is apart of
            // to the left. 
            int start = i;

            // You want to keep the stack going in increasing order.
            // The moment you come across an element that is less
            // than the top of the stack (given that the stack is 
            // non-empty) you peek the top of the stack and use that
            // to compute it's maximum possible area and see if it's
            // larger than the current largest max area.
            while(!stk.empty() && stk.top().second > heights[i]){
                pair<int,int> top = stk.top();
                int index = top.first;
                int height = top.second;

                max_area = max(max_area, height * (i - index));

                // Extend the potential start of the next element's rectangle
                // to the left.
                start = index;
                stk.pop();
            }

            stk.push({start, heights[i]});
        }

        // All the remaining elements in the stack
        // remained because they were not popped,
        // and that is because they can be further 
        // extended to the right... and they never
        // came across another value smaller than
        // itself. So, we extend the rectangles of
        // each of these remaining elements ALL
        // the way to the right. Hence why we do
        // 'n - index' in the computation of the
        // width of the rectangle below.
        while(!stk.empty()){
            int index = stk.top().first;
            int height = stk.top().second;
            
            max_area = max(max_area, height * (n - index));
            
            stk.pop();
        }

        return max_area;
    }
};
