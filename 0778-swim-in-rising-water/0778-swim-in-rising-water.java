class Solution {
    int[][] grid;
    int n;
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] dp;
    public int swimInWater(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        dp = new int[n][n];

        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dfs(0, 0, grid[0][0]);

        return dp[n-1][n-1];
    }

    void dfs(int i, int j, int cMax){
        if(i < 0 || j < 0 || i >= n || j >= n) return;

        cMax = Math.max(grid[i][j], cMax);
        
        if(dp[i][j] <= cMax) return;
        dp[i][j] = cMax;

        for(int[] d : dir){
            dfs(i+d[0], j+d[1], cMax);
        }
    }
}