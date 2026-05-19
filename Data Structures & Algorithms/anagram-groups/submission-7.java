class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String string = new String(arr);
            if(!map.containsKey(string)){
                map.put(string,new ArrayList<>());
            }
            map.get(string).add(strs[i]);
        }

        List<List<String>> ret = new ArrayList<>();

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ret.add(entry.getValue());
        }

        return ret;
    }
}
