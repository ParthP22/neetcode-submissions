class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            int[] freq = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                freq[strs[i].charAt(j) - 'a']++;
            }
            String freqString = Arrays.toString(freq);
            if(!map.containsKey(freqString)){
                map.put(freqString,new ArrayList<>());
            }
            map.get(freqString).add(strs[i]);
        }

        List<List<String>> ret = new ArrayList<>();

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ret.add(entry.getValue());
        }

        return ret;
    }
}
