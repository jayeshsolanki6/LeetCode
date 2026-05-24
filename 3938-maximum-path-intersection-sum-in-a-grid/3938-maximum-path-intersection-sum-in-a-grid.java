class Solution {
    public int maxScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = Integer.MIN_VALUE;
        if(m == 1 || n == 0){
            int curr = 0;
            for(int[] arr : grid){
                for(int num : arr){
                    curr += num;
                }
            }
            return curr;
        }

        if(n > 1){
            for(int[] arr : grid){
                int curr = arr[0] + arr[1];
                int maxi = curr;

                for(int i = 2; i<n; i++){
                    curr = Math.max(curr + arr[i], arr[i-1]+arr[i]);
                    maxi = Math.max(maxi, curr);
                }
                max = Math.max(max, maxi);
            }
        }
        if(m > 1){
            for(int i = 0; i<n; i++){
                int curr = grid[0][i] + grid[1][i];
                int maxi = curr;

                for(int j = 2; j<m; j++){
                    curr = Math.max(curr + grid[j][i], grid[j-1][i] + grid[j][i]);
                    maxi = Math.max(maxi, curr);
                }
                max = Math.max(max, maxi);
            }
        }

        for(int i = 1; i<m-1; i++){
            for(int j = 1; j<n-1; j++){
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }
}