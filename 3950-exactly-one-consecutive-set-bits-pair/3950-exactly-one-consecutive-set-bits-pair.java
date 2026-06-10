class Solution {
    public boolean consecutiveSetBits(int n) {
        char[] s = Integer.toBinaryString(n).toCharArray();

        int len = s.length;
        int count = 0;
        for(int i = 1; i<len; i++){
            if(s[i-1] == '1' && s[i] == '1') count++;
        }

        return count == 1;
    }
}