class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;
        while(j < len){
            char c = s.charAt(j);
            if(map.containsKey(c) && map.get(c) >= i){
                i = map.get(c) + 1;
            } 
            map.put(c, j);
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}