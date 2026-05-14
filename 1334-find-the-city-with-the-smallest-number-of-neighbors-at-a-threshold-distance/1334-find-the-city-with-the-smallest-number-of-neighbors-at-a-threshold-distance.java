class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp = new int[n][n];
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            dp[u][v] = wt;
            dp[v][u] = wt;
        }
        int max = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) continue;
                if(dp[i][j] == 0) dp[i][j] = max;
            }
        }

        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(dp[i][k] != max && dp[k][j] != max && dp[i][j] > dp[i][k] + dp[k][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        int minCities = max;
        int city = -1;

        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(dp[i][j] <= distanceThreshold) count++;
            }
            if(count <= minCities){
                minCities = count;
                city = i;
            }
        }
        return city;
    }
}