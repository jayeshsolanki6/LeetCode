class Solution {
    int[][] memo;
    int row, col;
    int max = Integer.MAX_VALUE / 2;
    public int minPathSum(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        memo = new int[row][col];
        for(int[] i : memo){
            Arrays.fill(i, -1);
        }
        return cal(grid, 0, 0);
    }
    int cal(int[][] grid, int m, int n){
        if(m == row || n == col){
            return max;
        }
        if(m == row-1 && n == col-1){
            return grid[m][n];
        }
        if(memo[m][n] != -1) return memo[m][n];
        int ans = grid[m][n] + Math.min(cal(grid, m+1, n), cal(grid, m, n+1));
        memo[m][n] = ans;
        return ans;
    }
}