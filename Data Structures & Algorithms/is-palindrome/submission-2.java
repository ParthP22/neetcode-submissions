class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        for(int i = 0, j = str.length() - 1; i < j;){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            while(i < j){
                if((ch1 < 'a' || ch1 > 'z') &&
                   (ch1 < '0' || ch1 > '9') ){
                    i++;
                    ch1 = str.charAt(i);
                }
                else{
                    break;
                }
            }
            while(i < j){
                if((ch2 < 'a' || ch2 > 'z') &&
                   (ch2 < '0' || ch2 > '9') ){
                    j--;
                    ch2 = str.charAt(j);
                }
                else{
                    break;
                }
            }
            
            if(ch1 != ch2){
                return false;
            }
            i++;
            j--;
        
        }
        return true;
    }
}
