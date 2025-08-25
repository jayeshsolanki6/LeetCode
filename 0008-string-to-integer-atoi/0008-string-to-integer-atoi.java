class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if(n == 0) return 0;
        
        long ans = 0;
        int sign = 1;
        int i = 0;
        if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if(s.charAt(i) == '+'){
            i++;
        }
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            ans = ans * 10 + (s.charAt(i) - '0');
            i++;
            if(ans*sign <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(ans*sign >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        return (int)ans*sign;
    }
}