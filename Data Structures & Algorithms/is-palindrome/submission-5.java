class Solution {
    public boolean isPalindrome(String s) {
        for(int left = 0, right = s.length() - 1; left < right;){
            while(!isAlphanumeric(s.charAt(left)) && left < right){
                left++;
            }
            while(!isAlphanumeric(s.charAt(right)) && left < right){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isAlphanumeric(char c){
        if(('a' <= c && c <= 'z') ||
           ('A' <= c && c <= 'Z') || 
           ('0' <= c && c <= '9')){
            return true;
        }
        return false;
    }
}
