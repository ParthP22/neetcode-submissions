class Solution {
public:
    string encode(vector<string>& strs) {
        if(strs.empty()){
            return "";
        }

        vector<int> sizes;

        string res;

        for(string& s : strs){
            sizes.push_back(s.size());
        }

        for(int size: sizes){
            // Append all the sizes and delimit
            // using commas
            res.append(to_string(size));
            res.push_back(',');
        }

        // Break encoding into two halves 
        // using '#'. The 1st half is the 
        // sizes and the 2nd half is their 
        // associated strings.
        res.push_back('#');

        // Now, for the 2nd half of the 
        // encoding, append ALL strings. 
        // No need to delimit because,
        // we will just refer to the
        // sizes in the 1st half of the
        // encoding.
        for(string& s : strs){
            res.append(s);
        }

        return res;
    }

    vector<string> decode(string s) {
        if(s.empty()){
            return {};
        }

        vector<int> sizes;
        vector<string> res;

        int i = 0;
        while(s[i] != '#'){
            int j = i;

            // The size number could be multi-digit.
            // So, use j to track how many digits the 
            // the size is.
            // All the sizes are delimited by ',', so
            // we go until then.
            while(s[j] != ','){
                j++;
            }

            // CPP note: the 2nd param in substr is NOT
            // the index where the substring ends, but rather
            // the length of the substring, which is why we 
            // pass j - i and not just j. 
            sizes.push_back(stoi(s.substr(i, j - i)));

            // Move to the first character of next size.
            i = j + 1;
        }

        // Skip over the '#' character
        i++;

        // Now, we can obtain all the
        // encoded strings by referring 
        // to the sizes that we obtained
        // earlier. 
        for(int size : sizes){
            res.push_back(s.substr(i, size));
            i += size;
        }

        return res;
    }
};
