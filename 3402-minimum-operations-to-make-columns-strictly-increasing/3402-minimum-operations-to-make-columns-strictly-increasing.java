class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;

        for(int i = 0; i<n; i++){
            int prev = -1;
            for(int j = 0; j<m; j++){
                if(grid[j][i] > prev){
                    prev = grid[j][i];
                } else{
                    res += prev - grid[j][i] + 1;
                    prev++;
                }
            }
        }

        return res;
    }
}