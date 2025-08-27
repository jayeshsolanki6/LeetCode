class Solution {
    int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long oddInd = n/2;
        long evenInd = n - oddInd;
        int ans = (int)((myPow(5, evenInd) * myPow(4, oddInd)) % mod);
        return ans;
    }
    public long myPow(long x, long n) {
        if(n == 0) return 1;
        if(n % 2 == 0){
            x = (x * x)%mod;
            n = n / 2;
            return myPow(x, n);
        }
        return x * myPow(x, --n) % mod;
    }
}