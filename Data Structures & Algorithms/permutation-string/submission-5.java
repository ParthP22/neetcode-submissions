class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        int right = 0; 

        for(; right < s1.length(); right++){
            s1Freq[s1.charAt(right) - 'a']++;
            s2Freq[s2.charAt(right) - 'a']++;
        }

        for(int left = 0; right < s2.length(); left++, right++){
            
            if(compareFreq(s1Freq, s2Freq)){
                return true;
            }
            
            s2Freq[s2.charAt(left) - 'a']--;
            s2Freq[s2.charAt(right) - 'a']++;
        }

        return compareFreq(s1Freq, s2Freq);
    }

    public boolean compareFreq(int[] s1Freq, int[] s2Freq){
        for(int i = 0; i < 26; i++){
            if(s1Freq[i] != s2Freq[i]){
                return false;
            }
        }

        return true;
    }
}
