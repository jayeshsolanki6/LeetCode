class Solution {
    int mod = (int)1e9 + 7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=target; j++){
                long res = 0;
                for(int l = 1; l<=k; l++){
                    if(j-l >= 0){
                        res += dp[i-1][j-l];
                        res %= mod;
                    }
                }
                dp[i][j] = (int)res;
            }
        }
        return dp[n][target];

    }
}