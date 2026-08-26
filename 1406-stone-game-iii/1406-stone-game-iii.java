class Solution {
    public String stoneGameIII(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        int diff = find(0, len, arr, dp);
        if(diff == 0) return "Tie";
        if(diff > 0) return "Alice";
        return "Bob";
    }

    int find(int i, int len, int[] arr, int[] dp){
        if(i == len) return 0;
        if(dp[i] != -1) return dp[i];
        int max = Integer.MIN_VALUE;

        if(len-i >= 1){
            max = Math.max(max, arr[i] - find(i+1, len, arr, dp));
        }
        if(len-i >= 2){
            max = Math.max(max, arr[i] + arr[i+1] - find(i+2, len, arr, dp));
        }
        if(len-i >= 3){
            max = Math.max(max, arr[i] + arr[i+1] + arr[i+2] - find(i+3, len, arr, dp));
        }

        return dp[i] = max;
    }
}