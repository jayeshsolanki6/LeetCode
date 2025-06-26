class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 != len2) return false;
        Map<Character, Integer> str1 = new HashMap<>();
        Map<Character, Integer> str2 = new HashMap<>();
        for(int i = 0; i<len1; i++){
            if(str1.get(s.charAt(i)) == null){
                str1.put(s.charAt(i), i);
            }
            if(str2.get(t.charAt(i)) == null){
                str2.put(t.charAt(i), i);
            }
            if(str1.get(s.charAt(i)) != str2.get(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}