class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // I got it all correct on my first try.
        // The intuition is very similar to that of the water container
        // problem: if the sum is too high, then move the right pointer
        // back by one. If it's too small, then move the left pointer
        // up by one. Keep going while left < right.
        
        int[] ret = new int[]{0,0};

        for(int i = 0, j = numbers.length - 1; i < j;){
            if(numbers[i] + numbers[j] == target){
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            }
            if(numbers[i] + numbers[j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return ret;
    }
}
