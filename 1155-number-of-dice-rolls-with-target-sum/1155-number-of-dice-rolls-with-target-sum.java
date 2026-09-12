class Solution {
    int mod = (int)1e9 + 7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return find(n, target, k, dp);

    }

    int find(int n, int t, int k, int[][] dp){
        if(t < 0) return 0;
        if(n == 0 && t == 0) return 1;
        if(n == 0) return 0;

        if(dp[n][t] != -1) return dp[n][t];
        long res = 0;
        for(int i = 1; i<=k; i++){
            res += find(n-1, t-i, k, dp);
            res %= mod;
        }
        return dp[n][t] = (int)res;
    }
}