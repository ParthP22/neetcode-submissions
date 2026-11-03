class Solution {
public:
    bool isPalindrome(string s) {
        for(int left = 0, right = s.length() - 1; left < right;){
            while(left < right && !isAlphanumeric(s[left])){
                left++;
            }
            while(left < right && !isAlphanumeric(s[right])){
                right--;
            }


            if(tolower(s[left]) == tolower(s[right])){
                left++;
                right--;
            }
            else{
                return false;
            }
            
        }

        return true;
    }

    bool isAlphanumeric(char c){
        if(
            ('a' <= c && c <= 'z') ||
            ('A' <= c && c <= 'Z') ||
            ('0' <= c && c <= '9')
        ){
            return true;
        }

        return false;
    }
};
