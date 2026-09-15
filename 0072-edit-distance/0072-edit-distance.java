class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1][len2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }  
        return find(len1-1, len2-1, word1, word2, dp);
    }
    int find(int i, int j, String s1, String s2, int[][] dp){
        if(j == -1) return i+1;
        if(i == -1){
            return j+1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = find(i-1, j-1, s1, s2, dp);
        } 
        int replace = 1 + find(i-1, j-1, s1, s2, dp);
        int delete = 1 + find(i-1, j, s1, s2, dp);
        int insert = 1 + find(i, j-1, s1, s2, dp);

        return dp[i][j] = Math.min(replace, Math.min(delete, insert));
    }
}