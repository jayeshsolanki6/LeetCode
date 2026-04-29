class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i<m; i++){
            if(grid[i][0] == 1){
                dfs(i, 0, grid);
            }
            if(grid[i][n-1] == 1){
                dfs(i, n-1, grid);
            }
        }
        for(int j = 1; j<n-1; j++){
            if(grid[0][j] == 1){
                dfs(0, j, grid);
            }
            if(grid[m-1][j] == 1){
                dfs(m-1, j, grid);
            }
        }
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    void dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = 2;
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
}