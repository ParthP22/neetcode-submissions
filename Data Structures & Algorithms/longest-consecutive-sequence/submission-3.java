class Solution {
    public int longestConsecutive(int[] nums) {
        // We store the length of the sequence as a value
        // to the key that is a part of the sequence.
        HashMap<Integer,Integer> map = new HashMap<>();

        int max = 0;

        for(int i = 0; i < nums.length; i++){
            // If we have not added this number to the map
            // yet, then do this.
            if(!map.containsKey(nums[i])){
                // We do 
                // map.getOrDefault(nums[i] - 1, 0) + 
                // map.getOrDefault(nums[i] + 1, 0) + 1
                // because this number may be the predecessor
                // or successor of a number in a sequence.
                // So, we take the the length of the sequence
                // up until this point, as well as the length
                // of the sequence that comes after it and
                // add one to this sum.
                // Notice that if there does not exist a
                // sequence before or after it, then the map
                // returns 0. So, we don't need to handle
                // that case.
                map.put(nums[i], 
                    map.getOrDefault(nums[i] - 1, 0) + 
                    map.getOrDefault(nums[i] + 1, 0) + 1
                );

                // We map the left boundary of this sequence 
                // to the new length of the sequence. 
                // Basically, we do:
                // nums[i] - (length of sequence up until it),
                // which will give us the left boundary of the
                // sequence that nums[i] is apart of. Then, we
                // update the value at the left boundary to be
                // the new length of the sequence that we
                // computed above.
                map.put(nums[i] - map.getOrDefault(nums[i] - 1, 0),
                    map.get(nums[i])
                );
                
                // We do the exact same thing here except for the
                // right boundary instead.
                map.put(nums[i] + map.getOrDefault(nums[i] + 1, 0),
                    map.get(nums[i])
                );

                // Update the max length.
                max = Math.max(max, map.get(nums[i]));
            }
        }

        return max;
    }
}
