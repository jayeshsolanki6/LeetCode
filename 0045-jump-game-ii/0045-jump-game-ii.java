class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return find(0, nums, nums.length, dp);
    }
    int find(int i, int[] nums, int len, int[] dp){
        if(i == len-1) return 0;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE/2;

        int reach = Math.min(len-1, i + nums[i]);
        for(int j = i+1; j<=reach; j++){
            min = Math.min(min, 1+find(j, nums, len, dp));
        }

        return dp[i] = min;
    }
}