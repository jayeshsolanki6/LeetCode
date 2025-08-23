class Solution {
    public int minimumArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int minR = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 1){
                    minR = Math.min(i, minR);
                    maxR = Math.max(i, maxR);
                    minC = Math.min(j, minC);
                    maxC = Math.max(j, maxC);
                }
            }
        }
        int ans = (maxR-minR+1) * (maxC-minC+1);
        return ans;
    }
}