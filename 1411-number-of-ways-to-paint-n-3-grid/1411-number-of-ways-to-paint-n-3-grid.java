class Solution {
    public int numOfWays(int n) {
        int mod = (int)1e9 + 7;
        long A = 6, B = 6;
        for(int i = 2; i<=n; i++){
            long nA = (A*3 + B*2) % mod;
            long nB = (A*2 + B*2) % mod;
            A = nA;
            B = nB;
        }
        return (int)((A + B) % mod);
    }
}