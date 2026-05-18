class Solution {
    public int superPow(int a, int[] b) {
        int m = 1140; //etf
        int M = 1337;
        int len = b.length;

        int pow = 0;
        int mul = 1;
        for(int i = len-1; i>=0; i--){
            pow += b[i]*mul;
            pow %= m;
            mul *= 10;
            mul %= m;
        }
        if(pow == 0) pow = m;
        // System.out.println(pow);
        return power(a, pow, M);
    }
    int power(int a, int b, int M){
        a %= M;
        int res = 1;
        while(b > 0){
            if(b%2 == 1){
                res = (res*a)%M;
            }
            a = (int)(1l*a*a)%M;
            b >>= 1;
        }
        return res;
    }
}