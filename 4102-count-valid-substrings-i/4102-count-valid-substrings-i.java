class Solution {
    public long countValidSubstrings(String s) {
        int len = s.length();
        long res = 0;
        int left = 0;

        for(int i = 0; i<len; i++){
            if(i > 1 && s.charAt(i-2) == 'a' && s.charAt(i-1) == 'b' && s.charAt(i) == 'c'){
                left = i-1;
            }
            res += i-left+1;
        }
        return res;
    }
}