class Solution {
    public int[][] merge(int[][] grid) {
        int row = grid.length;
        int count = 0;
        for(int i = 0; i<row; i++){
            if(grid[i][0] == -1) continue;
            for(int j = i+1; j<row; j++){
                if(grid[j][0] == -1) continue;
                if(grid[i][0] <= grid[j][0] && grid[i][1] >= grid[j][0]){
                    grid[i][1] = Math.max(grid[i][1], grid[j][1]);
                    grid[j][0] = -1;
                    count++;
                } else if(grid[j][0] <= grid[i][0] && grid[j][1] >= grid[i][0]){
                    grid[i][0] = grid[j][0];
                    grid[i][1] = Math.max(grid[i][1], grid[j][1]);
                    grid[j][0] = -1;
                    count++;
                }
            }
        }
        int[][] ans = new int[row-count][2];
        int j = 0;
        for(int i = 0; i<row; i++){
            if(grid[i][0] != -1){
                ans[j][0] = grid[i][0];
                ans[j][1] = grid[i][1];
                j++;
            }
        }
        return ans;

    }
}