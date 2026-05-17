class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // My bit-string approach (7/23/2025): fails test case below:
        // strs=["bdddddddddd","bbbbbbbbbbc"]
        // Time: O(m*n), Space: O(m*n)

        List<List<String>> ret = new ArrayList<>();

        HashMap<String,List<String>> matches = new HashMap<>();
        int[] freq = new int[26];
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                freq[strs[i].charAt(j) - 'a']++;
            }
            String bitString = createBitString(freq);
            if(!matches.containsKey(bitString)){
                matches.put(bitString, new ArrayList<>());
            }
            matches.get(bitString).add(strs[i]);
            clearArray(freq);
        }

        for(Map.Entry<String,List<String>> entry : matches.entrySet()){
            ret.add(entry.getValue());
        }
        return ret;
    }

    private void clearArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = 0;
        }
    }

    private String createBitString(int[] freq){
        // Idk why this code doesn't work as opposed
        // to Arrays.toString(freq);
        
        // StringBuilder bitString = new StringBuilder();
        // for(int i = 0; i < freq.length; i++){
        //     bitString.append(freq[i]);
        // }
        // return bitString.toString();
        return Arrays.toString(freq);
    }
}
