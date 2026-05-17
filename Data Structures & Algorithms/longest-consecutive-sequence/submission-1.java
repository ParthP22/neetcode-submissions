class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int max = Integer.MIN_VALUE;

        int currLength = 0;

        for(int num : nums){
            currLength = 0;
            int currNum = num;
            while(set.contains(currNum)){
                currLength++;
                currNum++;
            }
            max = Math.max(max,currLength);
        }
        return max;
    }

}
