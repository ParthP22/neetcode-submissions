class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> exists;

        int maxLength = 0;
        
        for(int left = 0, right = 0; right < s.size(); right++){
            while(exists.contains(s.at(right))){
                exists.erase(s.at(left));
                left++;
            }
            exists.insert(s.at(right));

            maxLength = max(maxLength, right - left + 1);
        }

        return maxLength;
    }
};
