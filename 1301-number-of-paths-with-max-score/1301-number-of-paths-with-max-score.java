class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
            }
        }

        dp[0][0][0] = 0;
        dp[0][0][1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                char c = board.get(i).charAt(j);

                if (c == 'X')
                    continue;

                int max = -1;

                if (i > 0)
                    max = Math.max(max, dp[i - 1][j][0]);
                if (j > 0)
                    max = Math.max(max, dp[i][j - 1][0]);
                if (i > 0 && j > 0)
                    max = Math.max(max, dp[i - 1][j - 1][0]);

                if (max == -1)
                    continue;

                int ways = 0;

                if (i > 0 && dp[i - 1][j][0] == max)
                    ways = (ways + dp[i - 1][j][1]) % MOD;

                if (j > 0 && dp[i][j - 1][0] == max)
                    ways = (ways + dp[i][j - 1][1]) % MOD;

                if (i > 0 && j > 0 && dp[i - 1][j - 1][0] == max)
                    ways = (ways + dp[i - 1][j - 1][1]) % MOD;

                int val = 0;
                if (c >= '1' && c <= '9')
                    val = c - '0';

                dp[i][j][0] = max + val;
                dp[i][j][1] = ways;
            }
        }

        if (dp[n - 1][n - 1][0] == -1)
            return new int[] {0, 0};

        return dp[n - 1][n - 1];
    }
}