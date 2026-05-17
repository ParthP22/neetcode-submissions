class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        HashSet<Character> exist = new HashSet<>();

        for(; right < s.length(); right++){
            while(exist.contains(s.charAt(right))){
                exist.remove(s.charAt(left++));
            }
            exist.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
