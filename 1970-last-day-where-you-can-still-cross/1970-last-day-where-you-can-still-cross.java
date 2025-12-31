class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int len = cells.length;
        int[][] grid = new int[row][col];
        for(int i = 0; i<len; i++){
            int[] cell = cells[i];
            grid[cell[0]-1][cell[1]-1] = i; 
        }
        int res = 0;
        int low = 0, high = len-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(isAvailable(grid, mid, row, col)){
                res = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return res+1;
    }

    boolean isAvailable(int[][] grid, int mid, int row, int col){
        for(int i = 0; i<col; i++){
            if(grid[0][i] > mid){
                int[][] vis = new int[row][col];
                if(bfs(grid, mid, vis, row, col, 0, i)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean bfs(int[][] grid, int num, int[][] vis, int row, int col, int i, int j){
        if(i == row-1) return true;
        vis[i][j] = 1;
        int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        boolean res = false;
        for(int[] d : dir){
            int nr = i+d[0], nc = j+d[1];
            if(nr <= 0 || nc < 0 || nr >= row ||
             nc >= col || vis[nr][nc] == 1 || grid[nr][nc] <= num) continue;
            res = res || bfs(grid, num, vis, row, col, nr, nc);
        }
        return res;
    }
}