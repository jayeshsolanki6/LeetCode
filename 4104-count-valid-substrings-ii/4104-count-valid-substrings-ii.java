class Solution {
    public long countValidSubstrings(String s) {
        int len = s.length();
        long res = 0;

        int a = -1, b = -1, c = -1;

        for(int i = 0; i<len; i++){
            char ch = s.charAt(i);

            if(ch == 'a') a = i;
            if(ch == 'b') b = a;
            if(ch == 'c') c = b;

            res += i - c;
        }

        return res;
    }
}