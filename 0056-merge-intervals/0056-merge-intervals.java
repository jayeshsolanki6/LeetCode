class Solution {
    public int[][] merge(int[][] grid) {
        int row = grid.length;
        Arrays.sort(grid, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int count = 0;
        for(int j = 1; j<row; j++){
            if(grid[i][0] == -1) continue;
            if(grid[i][1] >= grid[j][0]){
                grid[i][1] = Math.max(grid[j][1], grid[i][1]);
                grid[j][0] = -1;
                count++;
            } else{
                i = j;
            }
        }
        int[][] ans = new int[row-count][2];
        i = 0;
        for(int[] g : grid){
            if(g[0] != -1){
                ans[i][0] = g[0];
                ans[i][1] = g[1];
                i++;
            }
        }
        return ans;
    }
}