class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        for(int i = 0; i<m; i++){
            int low = 0, high = n-1;
            int ind = n;
            while(low<=high){
                int mid = (low+high)/2;
                if(grid[i][mid] < 0){
                    ind = mid;
                    high = mid-1;
                } else{
                    low = mid+1;
                }
            }
            count += n-ind;
        }
        return count;
    }
}