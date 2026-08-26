class Solution {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        for(int[] row : dp) Arrays.fill(row, -1);
        int diff = find(0, len-1, piles, dp);
        if(diff > 0) return true;
        return false;
    }
    int find(int i, int j, int[] piles, int[][] dp){
        if(i == j) return piles[i];
        if(dp[i][j] != -1) return dp[i][j];
        int max = Math.max(piles[i] - find(i+1, j, piles, dp), piles[j] - find(i, j-1, piles, dp));

        return dp[i][j] = max;
    }
}