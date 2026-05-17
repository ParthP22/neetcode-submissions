class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // We know -1000 <= nums[i] <= 1000, so we can
        // store frequencies like this.
        int[] freq = new int[2001];

        // The frequency of any possible number listed in the
        // range above can be 0 <= freq(nums[i]) <= nums.length.
        // So, the indices for the freqList below directly
        // correspond a possible frequency. 
        // For example, anything with frequency of 0 is at index 0,
        // anything with frequency of 1 is at index 1, and so on, 
        // until you get to anything with frequency of nums.length,
        // which is stored at the nums.length index (hence why we
        // need to initialize this array's size as nums.length + 1, 
        // since arrays are zero-indexed).
        List<Integer>[] freqList = new List[nums.length + 1];

        // Initialize all the lists at each index.
        for(int i = 0; i < nums.length+1; i++){
            freqList[i] = new ArrayList<>();
        }

        // Count up the frequency of all nums.
        for(int num : nums){
            freq[num + 1000]++;
        }

        // Add all the nums to their respective frequency list.
        // For example, if the number 1 has a frequency of 5,
        // then freq[i] = 5, so freqList[freq[i]] == freqList[5].
        // So, then you index into freqList[5] and add the number 1
        // to the list, since that entire list will contain elements
        // that have a frequency of 5.
        for(int i = 0; i < 2001; i++){
            freqList[freq[i]].add(i - 1000);
        }

        int[] topKFreq = new int[k];

        // You now want to traverse the freqList in reverse order
        // and skip the 0th element, since we don't care about
        // elements that have a frequency of 0, because freq == 0
        // means the element wasn't even the given nums array to
        // begin with. 
        // I started traversing the topKFreq backwards too, but
        // that is not necessary, since the instructions say you
        // can return your answer in any order. Notice that the
        // condition is i > 0 && j >= 0. As mentioned before, we
        // don't care about i == 0, and we do want to traverse
        // the entire topKFreq array, so we want j == 0.
        for(int i = nums.length, j = k - 1; i > 0 && j >= 0; i--){

            // We then traverse each individual frequency list.
            // We add each of these elements to the topKFreq array
            // and update the respective pointers.

            // Notice that we are not checking inside this inner loop
            // if j >= 0. We are exploiting the fact that the answer
            // to each test case will always be unique, as stated
            // in the instructions. So, we don't need to worry about
            // ties.

            // For example, let's say we want k = 2. Then, it cannot
            // be possible for the freqList at the last index to have
            // more than 2 elements, since that would mean the answer
            // is no longer unique. For example, let's say the freqList
            // at the last index of the freqList array has [4,5,6].
            // Then, the possible answers for k = 2 are: [4,5], [4,6],
            // or [5,6]. This means the answer is not unique.
            // Furthermore, we would need an extra condition inside
            // this inner-loop to check if j >= 0, since this list
            // [4,5,6] has size of 3, which means as we do m++ and j--,
            // it very possible we end up with j = -1 by the end, which
            // is out of bounds.
            for(int m = 0; m < freqList[i].size(); m++,j--){
                topKFreq[j] = freqList[i].get(m);
            }
        }   

        return topKFreq;

    }
}
