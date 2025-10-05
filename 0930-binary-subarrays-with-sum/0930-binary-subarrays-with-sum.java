class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return SWAM(nums, goal) - SWAM(nums, goal-1);
    }
    // sliding window at most
    int SWAM(int[] nums, int goal){
        if(goal < 0) return 0;
        int len = nums.length;
        int sum = 0, count = 0;
        int left = 0;
        for(int right = 0; right < len; right++){
            sum += nums[right];
            while(sum > goal){
                sum-=nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}