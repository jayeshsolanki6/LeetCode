class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        memo = new int[row][col];
        for(int[] i : memo){
            Arrays.fill(i, -1);
        }
        return cal(grid, 0, 0, row, col);
    }
    int cal(int[][] grid, int m, int n, int row, int col){
        if(m == row-1){
            int sum = 0;
            for(int i = n; i<col; i++){
                sum += grid[m][i];
            }
            return sum;
        }
        if(n == col-1){
            int sum = 0;
            for(int i = m; i<row; i++){
                sum += grid[i][n];
            }
            return sum;
        }
        if(memo[m][n] != -1) return memo[m][n];
        int ans = grid[m][n] + Math.min(cal(grid, m+1, n, row, col), cal(grid, m, n+1, row, col));
        memo[m][n] = ans;
        return ans;
    }
}