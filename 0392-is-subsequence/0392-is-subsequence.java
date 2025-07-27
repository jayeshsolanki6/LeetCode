class Solution {
    public boolean isSubsequence(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        int i = 0, j = 0;
        while(i < sLen && j < tLen){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == sLen;
    }
}