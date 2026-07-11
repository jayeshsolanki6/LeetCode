class Solution {
    public int calculate(String s) {
        int len = s.length();
        return cal(0, s, len)[0];
    }

    int[] cal(int i, String s, int len){
        if(i >= len) return new int[]{0, len};
        int res = 0, sign = 1, num = 0;
    
        while(i < len){
            char c = s.charAt(i);
            if(c == ' ') {}
            else if(c == '+') {
                res += sign*num;
                num = 0;
                sign = 1;
            }
            else if(c == '-') {
                res += sign*num;
                num = 0;
                sign = -1;
            }
            else if(c >= '0' && c <= '9'){
                num = num*10 + (c-'0'); 
            } 
            else if(c == ')') {
                res += num*sign;
                return new int[]{res, i};
            }
            else {
                int[] resp = cal(i+1, s, len);
                res += sign*resp[0];
                i = resp[1];
            } 
            i++;
        }
        res += num*sign;
        return new int[]{res, len};
    }
}