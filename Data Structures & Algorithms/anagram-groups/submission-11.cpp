class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ret;
        unordered_map<string,vector<string>> anagrams;

        for(int i = 0; i < strs.size(); i++){
            int freq[26] = {};

            for(int j = 0; j < strs[i].length(); j++){
                freq[strs[i][j] - 'a']++;
            }

            string encoding = "";

            for(int j = 0; j < 25; j++){
                encoding += freq[j];
                encoding += ",";
            }
            encoding += freq[25];

            if(!anagrams.contains(encoding)){
                anagrams[encoding] = {};
            }
            anagrams[encoding].push_back(strs[i]);
        }

        for(pair<string,vector<string>> entry : anagrams){
            ret.push_back(entry.second);
        }

        return ret;
    }
};
