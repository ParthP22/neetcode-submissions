class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        int left = 0;
        int right = (rows * cols) - 1;

        while(left <= right){
            int mid = (right - left)/2 + left;
            int curr = matrix[mid / cols][mid % cols];
            if(curr == target){
                return true;
            }

            if(curr < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return false;
    }
};
