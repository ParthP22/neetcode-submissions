class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int maxLength = 0;
        int maxFreq = 0;

        for(int left = 0, right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k){
                freq[s.charAt(left++) - 'A']--;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
