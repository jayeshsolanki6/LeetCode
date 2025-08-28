class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;

        int low = 0, high = m-1;
        int row = 0;
        while(low < high){
            int mid = (low + high)/2;
            int curr = matrix[mid][0];
            if(curr == target) return true;
            if(curr > target){
                row = mid-1;
                high = mid - 1;
            } else{
                row = mid;
                low = mid+1;
            }
        }
        low = 0;
        high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            int curr = matrix[row][mid];
            if(curr == target) return true;
            if(curr > target){
                high = mid - 1;
            } else{
                low = mid+1;
            }
        }
        return false;
    }
}