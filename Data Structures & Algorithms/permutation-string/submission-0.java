class Solution {

    private int[] s1Freq = new int[26];
    private int[] s2Freq = new int[26];

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

    
        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        if(isPerm()){
            return true;
        }
        s2Freq[s2.charAt(0) - 'a']--;

        for(int left = 1, right = s1.length(); right < s2.length(); left++,right++){
            
            s2Freq[s2.charAt(right) - 'a']++;
            if(isPerm()){
                return true;
            }
            s2Freq[s2.charAt(left) - 'a']--;

        }
        return false;

    }
    private boolean isPerm(){
        for(int i = 0; i < 26; i++){
            if(s1Freq[i] != s2Freq[i]){
                return false;
            }
        }
        return true;
    }
}
