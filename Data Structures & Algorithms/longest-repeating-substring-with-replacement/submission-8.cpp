class Solution {
public:
    int characterReplacement(string s, int k) {
        // int freq[26];

        // int max_length = 0;
        // int max_freq = 0;

        // for(int left = 0, right = 0; right < s.length(); right++){
        //     freq[s[right] - 'A']++;

        //     max_freq = max(max_freq, freq[s[right] - 'A']);

        //     while((right - left + 1) - max_freq > k){
        //         freq[s[left] - 'A']--;
        //         left++;
        //     }

        //     max_length = max(max_length, right - left + 1);
        // }

        // return max_length;

        unordered_map<char, int> count;
        int res = 0;

        int l = 0, maxf = 0;
        for (int r = 0; r < s.size(); r++) {
            count[s[r]]++;
            maxf = max(maxf, count[s[r]]);

            while ((r - l + 1) - maxf > k) {
                count[s[l]]--;
                l++;
            }
            res = max(res, r - l + 1);
        }

        return res;
    }
};
