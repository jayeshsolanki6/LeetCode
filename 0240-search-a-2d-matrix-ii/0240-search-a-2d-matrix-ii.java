class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        if(target < matrix[0][0] || target > matrix[n-1][m-1]) return false;

        for(int i = 0; i<n; i++){
            int low = 0, high = m-1;
            while(low <= high){
                int mid = (low+high)/2;
                int curr = matrix[i][mid];
                if(curr == target) return true;
                else if(curr < target){
                    low = mid+1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}