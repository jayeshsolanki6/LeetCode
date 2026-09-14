class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        find(m-1, n-1, matrix, dp);

        int maxLen = 0;
        for(int[] row : dp){
            for(int i : row) maxLen = Math.max(maxLen, i);
        }
        
        return maxLen * maxLen;
    }
    int find(int i, int j, char[][] matrix, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int max = Math.min(
            find(i-1, j-1, matrix, dp),
            Math.min(find(i-1, j, matrix, dp), find(i, j-1, matrix, dp))
        );

        int currMax = 0;
        if(matrix[i][j] == '1') currMax = max + 1;

        return dp[i][j] = currMax;
    }
}