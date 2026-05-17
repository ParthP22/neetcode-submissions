class Solution {
    public boolean isPalindrome(String s) {
        for(int left = 0, right = s.length() - 1; left < right; left++, right--){
            
            while(left < right && !isAlphaNum(s.charAt(left))){
                left++;
            }

            while(left < right && !isAlphaNum(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != 
               Character.toLowerCase(s.charAt(right))){
                return false;
            }
            
        }
        return true;
    }

    public boolean isAlphaNum(char ch){
        return ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9'));

    }
}
