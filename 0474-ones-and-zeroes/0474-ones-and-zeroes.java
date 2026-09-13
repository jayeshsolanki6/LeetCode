class Solution {
    int[] zeros, ones;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        zeros = new int[len];
        ones = new int[len];

        for(int i = 0; i<len; i++){
            for(char c : strs[i].toCharArray()){
                if(c == '0') zeros[i]++;
                else ones[i]++;
            }
        }

        int[][][] dp = new int[len][m+1][n+1];
        for(int[][] row2 : dp){
            for(int[] row : row2){
                Arrays.fill(row, -1);
            }
        }
        return find(len-1, m, n, dp);
    }
    int find(int i, int mz, int mo, int[][][] dp){
        if(i == -1) return 0;
        if(dp[i][mz][mo] != -1) return dp[i][mz][mo];
        int take = 0;
        if(zeros[i] <= mz && ones[i] <= mo){
            take = 1 + find(i-1, mz-zeros[i], mo-ones[i], dp);
        }
        int notTake = find(i-1, mz, mo, dp);

        return dp[i][mz][mo] = Math.max(take, notTake);
    }
}