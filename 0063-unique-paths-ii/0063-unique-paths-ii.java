class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    dp[j+1] = 0;
                } else{
                    dp[j+1] = dp[j] + dp[j+1];
                }
            }
        }
        return dp[n];
    }
}