class Solution {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int res = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] != 0 && !vis[i][j]){
                    long sum = find(i, j, m, n, grid, vis);
                    // System.out.println(sum);
                    if(sum%k == 0) res++;
                }
            }
        }

        return res;
    }

    long find(int i, int j, int m, int n, int[][] grid, boolean[][] vis){
        vis[i][j] = true;

        long sum = grid[i][j];

        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni >= 0 && nj >= 0 && ni < m && nj < n && !vis[ni][nj] && grid[ni][nj] != 0){
                sum += find(ni, nj, m, n, grid, vis);
            }
        }
        return sum;
    }
}