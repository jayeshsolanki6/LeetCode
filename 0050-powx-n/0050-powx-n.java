class Solution {
    public double myPow(double x, int nn) {
        long n = nn;
        if(n < 0){
            x = 1/x;
            n *= -1;
        }
        double res = 1;
        while(n > 0){
            if((n & 1) == 1){
                res *= x;
            }
            x = x*x;
            n = n >> 1;
        }
        return res;
    }
}