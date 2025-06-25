class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int len = strs[0].length();

        for(int i = 0; i<len; i++){
            char c = strs[0].charAt(i);
            for(String s: strs){
                if(i == s.length() || s.charAt(i) != c){
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }
}