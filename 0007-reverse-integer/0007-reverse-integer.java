class Solution {
    public int reverse(int x) {
        int rev = 0;
        int mul = 1;
        if(x < 0){
            mul = -1;
            x *= mul;
        }
        while(x > 0){
            if(rev > Integer.MAX_VALUE/10){
                return 0;
            }
            int temp = x % 10;
            rev = rev *10 + temp;
            x /= 10;
        }
        return rev*mul;
    }
}