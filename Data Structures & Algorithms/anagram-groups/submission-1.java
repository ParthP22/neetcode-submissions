class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String,List<String>> matches = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] currArr = strs[i].toCharArray();
            Arrays.sort(currArr);
            String curr = new String(currArr);
            if(!matches.containsKey(curr)){
                matches.put(curr,new ArrayList<String>());
            }
            matches.get(curr).add(strs[i]);
        }

        for(Map.Entry<String,List<String>> entry : matches.entrySet()){
            ret.add(entry.getValue());
        }

        return ret;
    }
}
