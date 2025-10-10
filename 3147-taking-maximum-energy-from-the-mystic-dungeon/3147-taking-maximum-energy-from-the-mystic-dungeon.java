class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int len = energy.length;
        int[] dp = new int[len];
        for(int i = len-1; i>=0; i--){
            if(i+k >= len){
                dp[i] = energy[i];
            } else{
                dp[i] = dp[i+k] + energy[i];
            }
        }
        int max = dp[0];
        for(int m : dp){
            max = Math.max(max, m);
        }
        return max;
    }
}