class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> ret = new LinkedList<>();
        for(int i = 0; i < strs.length; i++){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String sorted = new String(tmp);
            if(!map.containsKey(sorted)){
                map.put(sorted,new LinkedList<String>());
            }
            
            map.get(sorted).add(strs[i]);
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ret.add(entry.getValue());
        }
        return ret;
    }
}
