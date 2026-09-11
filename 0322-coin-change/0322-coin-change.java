class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int res = find(amount, coins, dp);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    int find(int amount, int[] coins, int[] dp){
        if(amount < 0) return Integer.MAX_VALUE;
        if(amount == 0) return 0;
        if(dp[amount] != -1) return dp[amount];

        int min = Integer.MAX_VALUE;
        for(int c : coins){
            int res = find(amount-c, coins, dp);
            if(res != Integer.MAX_VALUE) {
                min = Math.min(min, res+1);
            }
        }
        return dp[amount] = min;
    }
}