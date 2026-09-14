class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int len = tri.size();
        int[][] dp = new int[tri.get(len-1).size()][len];
        for(int[] row : dp){
            Arrays.fill(row, (int)1e9);
        }
        return find(0, 0, len, tri, dp);
    }
    int find(int i, int j, int len, List<List<Integer>> tri, int[][] dp){
        if(i == len) return 0;
        if(dp[i][j] != (int)1e9) return dp[i][j];
        int min = Math.min(find(i+1, j, len, tri, dp), find(i+1, j+1, len, tri, dp));

        return dp[i][j] = min + tri.get(i).get(j);
    }
}