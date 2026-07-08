class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ss = new String(arr);
            if(!map.containsKey(ss)) map.put(ss, new ArrayList<>());
            map.get(ss).add(s);
        }

        return new ArrayList<>(map.values());
    }
}