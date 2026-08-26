class Solution {
    public String stoneGameIII(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len+1];

        for(int i = len-1; i>=0; i--){
            int max = arr[i] - dp[i+1];
            
            if(i+2 <= len){
                max = Math.max(max, arr[i] + arr[i+1] - dp[i+2]);
            }
            if(i+3 <= len){
                max = Math.max(max, arr[i] + arr[i+1] + arr[i+2] - dp[i+3]);
            }

            dp[i] = max;
        }
        int diff = dp[0];
        if(diff == 0) return "Tie";
        if(diff > 0) return "Alice";
        return "Bob";
    }
}