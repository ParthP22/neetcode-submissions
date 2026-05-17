class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // For my previous submission, I did CTRL + Enter
        // on accident and it submitted my unfinished code :(
        if(s1.length() > s2.length()){
            return false;
        }

        int right = 0;
        int left = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(; right < s1.length(); right++){
            freq1[s1.charAt(right) - 'a']++;
            freq2[s2.charAt(right) - 'a']++;
        }
        
        for(; right < s2.length(); left++, right++){
            if(checkPermutation(freq1,freq2)){
                return true;
            }
            freq2[s2.charAt(left) - 'a']--;
            freq2[s2.charAt(right) - 'a']++;
        }
        return checkPermutation(freq1,freq2);
    }

    public boolean checkPermutation(int[] freq1, int[] freq2){
        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}
