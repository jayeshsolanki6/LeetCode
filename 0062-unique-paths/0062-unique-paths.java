class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m+1][n+1];
        // for()
        // Arrays.fill(memo, -1);
        return cal(m, n);
    }
    int cal(int m, int n){
        if(m == 1 || n == 1) return 1;
        if(memo[m][n] != 0) return memo[m][n];
        int ways = cal(m-1, n) + cal(m, n-1);
        memo[m][n] = ways;
        return ways;
    }
}