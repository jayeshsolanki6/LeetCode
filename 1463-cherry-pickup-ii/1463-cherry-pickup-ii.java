class Solution {
    public int cherryPickup(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        int[][][] dp = new int[m][n][n];
        for(int[][] mat : dp){
            for(int[] row : mat){
                Arrays.fill(row, -1);
            }
        }
        helper(0, 0, n-1, dp, m, n, g);
        return dp[0][0][n-1];
    }
    int helper(int i, int j1, int j2, int[][][] dp, int m, int n, int[][] g){
        
        if(i == m-1){
            if(j1 == j2) return g[i][j1];
            return g[i][j1] + g[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = 0;
        for(int k = -1; k<=1; k++){
            for(int l = -1; l<=1; l++){
                int nj1 = j1 + k, nj2 = j2 + l;
                if(nj1 < 0 || nj2 < 0 || nj1 >= n || nj2 >= n){
                    continue;
                }
                max = Math.max(max, helper(i+1, nj1, nj2, dp, m, n, g));
            }
        }
        if(j1 == j2){
            return dp[i][j1][j2] = max + g[i][j1];
        }
        return dp[i][j1][j2] = max + g[i][j1] + g[i][j2];
    }
}