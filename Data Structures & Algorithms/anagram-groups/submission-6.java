class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            int[] freq = new int[26];

            for(int j = 0; j < strs[i].length(); j++){
                freq[strs[i].charAt(j) - 'a']++;
            }

            String encoding = Arrays.toString(freq);
            map.putIfAbsent(encoding, new ArrayList<>());
            map.get(encoding).add(strs[i]);
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ret.add(entry.getValue());
        }

        return ret;
    }
}
