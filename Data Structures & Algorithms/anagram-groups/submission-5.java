class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] stringArr = strs[i].toCharArray();
            Arrays.sort(stringArr);
            String newString = new String(stringArr);
            if(!map.containsKey(newString)){
                map.put(newString, new ArrayList<>());
            }
            map.get(newString).add(strs[i]);
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ret.add(entry.getValue());
        }
        return ret;
    }
}
