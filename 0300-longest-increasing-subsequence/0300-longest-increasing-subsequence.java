class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        int res = 0;
        for(int i = 0; i<len; i++){
            res = Math.max(res, find(i, nums, dp));
        }
        return res;
    }
    int find(int i, int[] nums, int[] dp){
        if(i == -1) return 0;
        if(dp[i] != -1) return dp[i];
        int take = 1;
        for(int j = 0; j<i; j++){
            if(nums[j] < nums[i]){
                take = Math.max(take, 1 + find(j, nums, dp));
            }
        }

        return dp[i] = take;
    }
}