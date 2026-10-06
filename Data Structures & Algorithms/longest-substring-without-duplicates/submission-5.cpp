class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> exists;

        int longest = 0;

        for(int left = 0, right = 0; right < s.size(); right++){
            while(exists.contains(s[right])){
                exists.erase(s[left]);
                left++;
            }

            exists.insert(s[right]);

            longest = max(longest, right - left + 1);
        }

        return longest;
    }
};
