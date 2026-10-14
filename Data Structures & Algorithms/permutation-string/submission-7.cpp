class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int s1_freq[26] = {0};
        int s2_freq[26] = {0};

        int right = 0;

        for(; right < s1.length(); right++){
            s1_freq[s1[right] - 'a']++;
            s2_freq[s2[right] - 'a']++;
        }

        for(int left = 0; right < s2.length(); left++, right++){
            bool same_freq = true;

            for(int i = 0; i < 26; i++){
                if(s1_freq[i] != s2_freq[i]){
                    same_freq = false;
                    break;
                }
            }

            if(same_freq){
                return true;
            }

            s2_freq[s2[left] - 'a']--;
            s2_freq[s2[right] - 'a']++;
        }

        bool same_freq = true;

        for(int i = 0; i < 26; i++){
            if(s1_freq[i] != s2_freq[i]){
                same_freq = false;
                break;
            }
        }

        if(same_freq){
            return true;
        }
        return false;
    }
};
