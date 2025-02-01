class Solution {
    public int[] runningSum(int[] nums) {
        rSum(nums, 0, 0);
        return nums;
    }
    public void rSum(int[] nums, int n, int sum){
        if(n == nums.length){
            return;
        }
        sum += nums[n];
        rSum(nums, n + 1, sum);
        nums[n] = sum;
    }
}