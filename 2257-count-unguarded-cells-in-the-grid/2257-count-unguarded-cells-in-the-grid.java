class Solution {
    int m, n;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        this.m = m;
        this.n = n;
        int[][] grid = new int[m][n];
        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 1;
        }
        for(int[] guard : guards){
            grid[guard[0]][guard[1]] = 2;
        }
        for(int[] guard : guards){
            helper(grid, guard, 0, 1);
            helper(grid, guard, 0, -1);
            helper(grid, guard, 1, 0);
            helper(grid, guard, -1, 0);
        }
        int res = 0;
        for(int[] row : grid){
            for(int i : row){
                if(i == 0) res++;
            }
        }
        return res;
    }
    void helper(int[][] grid, int[] guard, int xFac, int yFac){
        int x = guard[0]+xFac, y = guard[1]+yFac;
        while(x < m && y < n && x >= 0 && y >= 0){
            if(grid[x][y] == 1 || grid[x][y] == 2) break;
            grid[x][y] = 3;
            x += xFac;
            y += yFac;
        }
    }
}