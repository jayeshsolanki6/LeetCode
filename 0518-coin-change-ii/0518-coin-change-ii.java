class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for(int[] row : dp) Arrays.fill(row, -1);

        return find(amount, coins.length-1, coins, dp);
    }
    int find(int amount, int i, int[] coins, int[][] dp){
        if(amount < 0) return 0;
        if(amount == 0) return 1;
        if(i == -1) return 0;

        if(dp[amount][i] != -1) return dp[amount][i];

        int take = find(amount - coins[i], i, coins, dp);
        int notTake = find(amount, i-1, coins, dp);

        return dp[amount][i] = take + notTake;
    }
}