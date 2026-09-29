class Solution {
    int maxOpenB;
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        maxOpenB = (m+n-1)/2;
        Boolean[][][] dp = new Boolean[m][n][maxOpenB+1];

        return find(m-1, n-1, (grid[m-1][n-1] == ')') ? 1 : -1, grid, dp);
    }
    boolean find(int i, int j, int sum, char[][] grid, Boolean[][][] dp){
        if(i < 0 || j < 0 || sum < 0 || sum > maxOpenB) return false;
        if(i == 0 && j == 0 && sum == 0) return true;

        if(dp[i][j][sum] != null) return dp[i][j][sum];
        boolean up = false, down = false;
        if(i-1 >= 0){
            up = find(i-1, j, sum + ((grid[i-1][j] == ')') ? 1 : -1), grid, dp);
        }

        if(j-1 >= 0){
            down = find(i, j-1, sum + ((grid[i][j-1] == ')') ? 1 : -1), grid, dp);
        }

        return dp[i][j][sum] = down || up;
    }
}