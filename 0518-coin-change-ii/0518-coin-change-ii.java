class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[amount+1][coins.length];
        
        for(int i = 0; i<len; i++) dp[0][i] = 1;

        for(int a = 1; a<=amount; a++){
            for(int i = 0; i<len; i++){
                int take = 0, notTake = 0;
                if(a >= coins[i]){
                    take = dp[a-coins[i]][i];
                }
                if(i > 0){
                    notTake = dp[a][i-1];
                }
                dp[a][i] = take + notTake;
            }
        }

        return dp[amount][len-1];
    }

}