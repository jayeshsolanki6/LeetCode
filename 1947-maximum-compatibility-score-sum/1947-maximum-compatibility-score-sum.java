class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        int[][] dp = new int[m][1 << m];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return find(0, 0, students, mentors, dp);
    }
    int find(int i, int mask, int[][] students, int[][] mentors, int[][] dp) {
        int m = students.length;
        int n = students[0].length;
        if(i == m) return 0;
        if(dp[i][mask] != -1) return dp[i][mask];

        int max = Integer.MIN_VALUE;

        for(int j = 0; j<m; j++){
            if(((1 << j) & mask) == 0){
                int score = 0;
                for(int k = 0; k<n; k++){
                    score += ((students[i][k] ^ mentors[j][k]) == 0) ? 1 : 0;
                }
                max = Math.max(max, score + find(i+1, (1 << j)|mask, students, mentors, dp));
            }
        }

        return dp[i][mask] = max;
    }
}